package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cartoonworld.kg.hightime.test.Test1Activity;
import com.cartoonworld.kg.hightime.test.Test2Activity;

public class StudentamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentam);
    }

    public void Test1ActivityOpen(View view) {
        Intent intent = new Intent(this, Test1Activity.class);

        startActivity(intent);
    }

}
