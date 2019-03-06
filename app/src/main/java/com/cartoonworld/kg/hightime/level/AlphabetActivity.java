package com.cartoonworld.kg.hightime.level;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.GetCallClass;
import com.cartoonworld.kg.hightime.R;
import com.cartoonworld.kg.hightime.test.GetCallListener;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AlphabetActivity extends AppCompatActivity implements GetCallListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        new GetCallClass(this,"api/level/" + getIntent().getStringExtra("EXTRA_LEVEL_ID") ).execute();


    }

    @Override
    public void updateResult(String result) {
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
}
