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
import com.cartoonworld.kg.hightime.ONasActivity;
import com.cartoonworld.kg.hightime.R;
import com.cartoonworld.kg.hightime.test.GetCallListener;
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





        //String path="http://www.ted.com/talks/download/video/8584/talk/761";
        //String path1="http://commonsware.com/misc/test2.3gp";

        /*Uri uri=Uri.parse(LINK);

        VideoView video=(VideoView)findViewById(R.id.myVideo);
        video.setVideoURI(uri);
        video.start();

        video.pause();*/

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
                Log.e("ffff", jsonVideos.getString("name"));

                View element_level = getLayoutInflater().inflate(R.layout.element_lessons, null);

                TextView lessonTitle = (TextView) element_level.findViewById(R.id.lesson_title);
                //ellipseText.setTag( jsonObject.getString("id") );
                lessonTitle.setText( jsonVideos.getString("name") );
                ImageView button_video_play = (ImageView) element_level.findViewById(R.id.button_video_play);
                button_video_play.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){

                        Intent intent = new Intent(LessonsActivity.this, VideoActivity.class);
                        //intent.putExtra("EXTRA_LEVEL_ID", String.valueOf(arg0.getTag())  );
                        //Log.e("id ", String.valueOf(arg0.getTag()));
                        startActivity(intent);
                    }
                } );

                layout.addView(element_level);



            }




            /*    Log.e("ffff", jsonObject.getString("content") );

            TextView content = (TextView) findViewById(R.id.alphabet_content);
            content.setText( jsonObject.getString("content") );

            Uri uri = Uri.parse( jsonObject.getString("thumbnail") );
            SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
            draweeView.setImageURI(uri);
*/
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
