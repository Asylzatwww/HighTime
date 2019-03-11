package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.test.Test1Activity;

public class StudentamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentam);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        findViewById(R.id.my_toolbar).bringToFront();

        TextView my_toolbar_tex_id = myToolbar.findViewById(R.id.my_toolbar_tex_id);
        my_toolbar_tex_id.setText("Уровни английского языка");

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void Test1ActivityOpen(View view) {
        Intent intent = new Intent(this, Test1Activity.class);

        startActivity(intent);
    }

}
