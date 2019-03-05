package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cartoonworld.kg.hightime.level.AlphabetActivity;

public class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
    }

    public void clickF(View view){
        Log.e("Clicked", "clicked");
    }

    public void AlphabetActivityOpen(View view) {
        Intent intent = new Intent(this, AlphabetActivity.class);

        startActivity(intent);
    }


}
