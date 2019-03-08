package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private String instructionAcitivityId;

    public String getInstructionAcitivityId() {
        return instructionAcitivityId;
    }

    public void setInstructionAcitivityId(String id) {
        this.instructionAcitivityId = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
/*
        String json = "{\"result\":{\"success\":{\"user_token\":\"e1db938d921ba74ea5057215597e23f9\"}},\"user\":{\"id\":3369,\"fullName\":\"dd \",\"email\":\"d@dds.ru\"}}";

        JSONObject jsonObject = null;
        String user = "";
        try {
            jsonObject = new JSONObject(json);
            jsonObject = new JSONObject( jsonObject.getString("user") );

            user = jsonObject.getString("id");

            Log.e("json", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/

        //SaveSharedPreference.setUserName(MainActivity.this, "");

        RefreshUserStatus();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        RefreshUserStatus();
    }

    public void RefreshUserStatus(){
        if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0)
        {
            Log.e("Not Created", "false");

            Button btn_login = (Button) findViewById(R.id.btn_login);
            btn_login.setVisibility(View.VISIBLE);

            Button btn_registration = (Button) findViewById(R.id.btn_registration);
            btn_registration.setVisibility(View.VISIBLE);

            Button btn_quit = (Button) findViewById(R.id.btn_quit);
            btn_quit.setVisibility(View.GONE);

            // call Login Activity
        }
        else
        {
            Log.e("Not created", SaveSharedPreference.getUserName(MainActivity.this) );
            Button btn_login = (Button) findViewById(R.id.btn_login);
            btn_login.setVisibility(View.GONE);

            Button btn_registration = (Button) findViewById(R.id.btn_registration);
            btn_registration.setVisibility(View.GONE);

            Button btn_quit = (Button) findViewById(R.id.btn_quit);
            btn_quit.setVisibility(View.VISIBLE);

            // Stay at the current activity.
        }
    }

    public void QuitUser(View view){
        SaveSharedPreference.setUserName(MainActivity.this, "");
        RefreshUserStatus();
    }


    /** Called when the user taps the Send button */
    public void ONasActivityOpen(View view) {
        Intent intent = new Intent(this, ONasActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void StudentamActivityOpen(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    /** Called when the user taps the Send button */
    public void InstructionActivityOpen(View view) {
        Intent intent = new Intent(this, StudentamActivity.class);

        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void RegisterActivityOpen(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);

        startActivity(intent);
    }

    public void LoginActivityOpen(View view) {
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }

    public void FilialActivityOpen(View view) {
        Intent intent = new Intent(this, FilialyActivity.class);

        startActivity(intent);
    }

    public void ContactActivityOpen(View view) {
        Intent intent = new Intent(this, ContactActivity.class);

        startActivity(intent);
    }

    public void NashaComandaActivityOpen(View view) {
        Intent intent = new Intent(this, NashaKomandaActivity.class);

        startActivity(intent);
    }

    public void NewsActivityOpen(View view){
            Intent intent = new Intent (this, NewsAktivity.class);

            startActivity(intent);
    }
}
