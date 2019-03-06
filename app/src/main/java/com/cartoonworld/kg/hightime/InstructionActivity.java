package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.level.AlphabetActivity;
import com.cartoonworld.kg.hightime.test.GetCallListener;
import com.cartoonworld.kg.hightime.test.Test1Activity;
import com.cartoonworld.kg.hightime.test.Test2Activity;
import com.cartoonworld.kg.hightime.test.TestQuestionConstructor;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;

public class InstructionActivity extends AppCompatActivity implements GetCallListener {
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        new GetCallClass(this,"api/level" ).execute();

    }

    public void clickF(View view){
        Log.e("Clicked", "clicked");
    }

    public void AlphabetActivityOpen(View view) {
        Intent intent = new Intent(this, AlphabetActivity.class);
        intent.putExtra("EXTRA_LEVEL_ID", "2");
        startActivity(intent);
    }

    public void LevelActivityOpen(String id) {
        Intent intent = new Intent(this, AlphabetActivity.class);
        intent.putExtra("EXTRA_LEVEL_ID", id);
        startActivity(intent);
    }


    @Override
    public void updateResult(String result) {
        Log.e("str  ", result);
        try {
            JSONArray jsonArray = new JSONArray(result);
            GridLayout layout = (GridLayout) findViewById(R.id.level_layout);

            for (int i =0; i< jsonArray.length(); i++){

                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.e("ffff", jsonObject.getString("id") );
                Log.e("ffff", jsonObject.getString("name") );

                id = jsonObject.getString("id");




                /***  Button configurations ***/

                View element_level = getLayoutInflater().inflate(R.layout.element_level, null);

                Uri uri = Uri.parse( jsonObject.getString("thumbnail") );
                SimpleDraweeView draweeView = (SimpleDraweeView) element_level.findViewById(R.id.level_image_view);
                draweeView.setImageURI(uri);

                element_level.findViewById(R.id.level_image_view).setTag( jsonObject.getString("id") );
                element_level.findViewById(R.id.level_image_view).setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){

                        Intent intent = new Intent(InstructionActivity.this, AlphabetActivity.class);
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
