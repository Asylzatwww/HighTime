package com.cartoonworld.kg.hightime.level;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.GetCallClass;
import com.cartoonworld.kg.hightime.Globals;
import com.cartoonworld.kg.hightime.R;
import com.cartoonworld.kg.hightime.test.GetCallListener;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlphabetActivity extends AppCompatActivity implements GetCallListener {

    private static final String API_LEVEL = "api/level/%s";
    private static final String API_LESSON_GET_BY_LEVEL = "api/lesson/get-by-level/%s";
    private int actionIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);


        //apiLevel = "api/level/" + getIntent().getStringExtra("EXTRA_LEVEL_ID");
        actionIndex = 1;

        Globals g = Globals.getInstance();
        String instructionActivityId = getIntent().getStringExtra("EXTRA_LEVEL_ID");

        if (instructionActivityId == null)
            instructionActivityId=g.getInstructionActivityId();

        String url = String.format(API_LEVEL, instructionActivityId);

        new GetCallClass(this,
                url
        ).execute();

        url = String.format(API_LESSON_GET_BY_LEVEL, instructionActivityId);

        actionIndex = 2;
        new GetCallClass(this,
                url
        ).execute();

    }

    @Override
    public void updateResult(String result, String url) {


        if ( actionIndex ==  1 ){

            Log.e("str  ", result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                Log.e("ffff", jsonObject.getString("content") );

                TextView content = (TextView) findViewById(R.id.alphabet_content);
                content.setText( jsonObject.getString("content") );

                Uri uri = Uri.parse( jsonObject.getString("thumbnail") );
                SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
                draweeView.setImageURI(uri);

                setTitle("Уровень " + jsonObject.getString("name") );

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        else if (actionIndex ==  2 ){





            Log.e("str  ", result);
            try {
                JSONArray jsonArray = new JSONArray(result);
                GridLayout layout = (GridLayout) findViewById(R.id.get_by_level_layout);

                for (int i =0; i< jsonArray.length(); i++){

                    final JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Log.e("ffff", jsonObject.getString("id") );





                    /***  Button configurations ***/

                    View element_level = getLayoutInflater().inflate(R.layout.element_get_by_level, null);

                    TextView ellipseText = (TextView) element_level.findViewById(R.id.ellipse_text);
                    ellipseText.setTag( jsonObject.getString("id") );
                    ellipseText.setText( jsonObject.getString("id") );
                    ellipseText.setOnClickListener( new View.OnClickListener(){
                        public void onClick(View arg0){

                            Intent intent = new Intent(AlphabetActivity.this, LessonsActivity.class);
                            intent.putExtra("EXTRA_LEVEL_ID", String.valueOf(arg0.getTag())  );
                            Log.e("id ", String.valueOf(arg0.getTag()));
                            startActivity(intent);
                        }
                    } );

                    layout.addView(element_level);


                }

            /*TextView content = (TextView) findViewById(R.id.alphabet_content);
            content.setText( jsonObject.getString("content") );

*/
            } catch (JSONException e) {
                e.printStackTrace();
            }























        }

    }
}
