package com.cartoonworld.kg.hightime.test;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.cartoonworld.kg.hightime.MainActivity;
import com.cartoonworld.kg.hightime.R;

public class Test3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);



        /**  Test Activity - AddRadio Usage ***/
        LinearLayoutCompat layout = (LinearLayoutCompat) findViewById(R.id.testLayout);

        Resources res = getResources();
        String[] questionDescriptopion = res.getStringArray(R.array.quesDesc);
        String[] questionText = res.getStringArray(R.array.questTest);

        TestQuestionConstructor testQuestionConstructor = new TestQuestionConstructor(layout,
                questionDescriptopion, questionText);

        testQuestionConstructor.addRadio( 10,30,4, getLayoutInflater().inflate(R.layout.test_question, null) );
        testQuestionConstructor.addRadio( 11,31,4, getLayoutInflater().inflate(R.layout.test_question, null) );
        testQuestionConstructor.addRadio( 12,35,4, getLayoutInflater().inflate(R.layout.test_question, null) );
        testQuestionConstructor.addRadio( 13,39,4, getLayoutInflater().inflate(R.layout.test_question, null) );
        testQuestionConstructor.addRadio( 14,43,4, getLayoutInflater().inflate(R.layout.test_question, null) );


        /*** Test Activity - Radio Add end **/

        /***  Button configurations ***/

        View buttonTest2 = getLayoutInflater().inflate(R.layout.button, null);

        Button buttonNext = buttonTest2.findViewById(R.id.button_next);
        Button buttonPrevious = buttonTest2.findViewById(R.id.button_previous);

        //buttonPrevious.setVisibility( View.GONE );

        buttonPrevious.setOnClickListener( new View.OnClickListener(){
            public void onClick(View arg0){
                //Start new activity class
                Intent myIntent=new Intent(Test3Activity.this,Test2Activity.class);
                startActivity(myIntent);
            }
        } );

        buttonNext.setOnClickListener( new View.OnClickListener(){
            public void onClick(View arg0){
                //Start new activity class
                Intent myIntent=new Intent(Test3Activity.this, MainActivity.class);
                startActivity(myIntent);
            }
        } );

        layout.addView(buttonTest2);


        /***  Button configurations End  ***/


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        Log.e("Radio - id : ", String.valueOf(view.getId()));

    }

}
