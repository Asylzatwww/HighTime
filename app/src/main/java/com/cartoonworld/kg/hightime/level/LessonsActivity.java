package com.cartoonworld.kg.hightime.level;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.cartoonworld.kg.hightime.GetCallClass;
import com.cartoonworld.kg.hightime.Globals;
import com.cartoonworld.kg.hightime.ONasActivity;
import com.cartoonworld.kg.hightime.R;
import com.cartoonworld.kg.hightime.test.GetCallListener;
import com.cartoonworld.kg.hightime.test.Test1Activity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LessonsActivity extends AppCompatActivity implements GetCallListener {

    private static final String API_LESSON_SHOW = "api/lesson/show/%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        new GetCallClass(this,
                String.format(API_LESSON_SHOW, getIntent().getStringExtra("EXTRA_LEVEL_ID"))
        ).execute();

    }

    @Override
    public void updateResult(String result, String url) {

        Log.e("str  ", result);
        try {
            JSONObject jsonObject = new JSONObject(result);

            JSONArray jsonArray = new JSONArray( jsonObject.getString("videos") );

            LinearLayout layout = (LinearLayout) findViewById(R.id.rectangle);

            for (int i =0; i< jsonArray.length(); i++) {

                JSONObject jsonVideos = jsonArray.getJSONObject(i);

                View element_level = getLayoutInflater().inflate(R.layout.element_lessons, null);

                TextView lessonTitle = (TextView) element_level.findViewById(R.id.lesson_title);
                lessonTitle.setText( jsonVideos.getString("name") );
                Log.e("ffff", jsonVideos.getString("name"));

                ImageView button_video_play = (ImageView) element_level.findViewById(R.id.button_video_play);
                button_video_play.setTag( jsonVideos.getString("url_high") );
                button_video_play.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){

                        Intent intent = new Intent(LessonsActivity.this, VideoActivity.class);
                        intent.putExtra("EXTRA_VIDEO_URL", String.valueOf(arg0.getTag())  );
                        startActivity(intent);
                    }
                } );

                layout.addView(element_level);



                /**********************************    Add video tests   ***********************************/

                JSONArray jsonTests = new JSONArray( jsonVideos.getString("tests") );

                if ( jsonTests.length() > 0 ){
                    View element_level_test = getLayoutInflater().inflate(R.layout.element_lessons, null);
                    TextView lessonTitleTest = (TextView) element_level_test.findViewById(R.id.lesson_title);
                    lessonTitleTest.setText( "Пройти Тест" );

                    ImageView button_video_play_test = (ImageView) element_level_test.findViewById(R.id.button_video_play);
                    button_video_play_test.setTag( jsonVideos.getString("tests") );
                    button_video_play_test.setOnClickListener( new View.OnClickListener(){
                        public void onClick(View arg0){
                            parseJsonTesttoArray( String.valueOf(arg0.getTag()) );

                            Log.e("TTTTTTTTTTTTTTTT", String.valueOf(arg0.getTag()));

                            Intent intent = new Intent(LessonsActivity.this, Test1Activity.class);
                            intent.putExtra("EXTRA_VIDEO_URL", String.valueOf(arg0.getTag())  );
                            startActivity(intent);
                        }
                    } );

                    layout.addView(element_level_test);
                }


                /*********************************     video tests ended  ****************************************/







            }




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void parseJsonTesttoArray(String testString){
        Globals g = Globals.getInstance();
        g.setTestsArray( testString );

        /****************************   test construction  *****************************/


        try {
            JSONArray jsonTests = new JSONArray( testString );
            String[] questionDescriptopion = new String[ jsonTests.length() ];
            String[] questionText = new String[100];
            int[] answerStart = new int[100];
            int[] answerLength = new int[100];


            for (int i=0;i<jsonTests.length();i++){

                JSONObject jsonTest = jsonTests.getJSONObject(i);
                questionDescriptopion[i] = (jsonTest.has("name")) ? jsonTest.getString("name") : "";


                JSONArray jsonAnswers = new JSONArray( jsonTest.getString("answers") );
                answerLength[i] = jsonAnswers.length();
                if (i > 0) answerStart[i] = answerStart[i-1] + answerLength[i];
                else answerStart[i] = answerLength[i];
                for (int j=0;j<jsonAnswers.length();j++){
                    JSONObject jsonAnswer = jsonAnswers.getJSONObject(j);
                    questionText[ answerStart[i] + j] = jsonAnswer.getString("name");
                }

            }

            g.setQuestionDescriptopion( questionDescriptopion );
            g.setQuestionText( questionText );
            g.setAnswerLength( answerLength );
            g.setAnswerStart( answerStart );


        } catch (JSONException e) {
            e.printStackTrace();
        }

        /***********************    test construction end   ************************/

    }
}
