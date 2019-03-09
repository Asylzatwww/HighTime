package com.cartoonworld.kg.hightime.test;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.Globals;
import com.cartoonworld.kg.hightime.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Globals g = Globals.getInstance();


        if (g.getQuestionDescriptopion().length > 0){


            String[] questionDescriptopion = g.getQuestionDescriptopion();
            String[] questionText = g.getQuestionText();
            int[] answerStart = g.getAnswerStart();
            int[] answerLength = g.getAnswerLength();

            Log.e("Test Array String : ", g.getTestsArray() );




            LinearLayoutCompat layout = (LinearLayoutCompat) findViewById(R.id.testLayout);
            TestQuestionConstructor testQuestionConstructor = new TestQuestionConstructor(layout,
                    questionDescriptopion, questionText );

            for (int i=0; i< questionDescriptopion.length; i++) {
                testQuestionConstructor.addRadio(i, answerStart[i], answerLength[i], getLayoutInflater().inflate(R.layout.test_question, null));
            }

            /*for (int i=0;i<jsonTests.length();i++){
                JSONObject jsonTest = jsonTests.getJSONObject(i);

            }*/
        } else {

            /**  Test Activity - AddRadio Usage ***/
            LinearLayoutCompat layout = (LinearLayoutCompat) findViewById(R.id.testLayout);

            Resources res = getResources();
            String[] questionDescriptopion = res.getStringArray(R.array.quesDesc);
            String[] questionText = res.getStringArray(R.array.questTest);

            TestQuestionConstructor testQuestionConstructor = new TestQuestionConstructor(layout,
                    questionDescriptopion, questionText);

            testQuestionConstructor.addRadio( 0, 0,3,getLayoutInflater().inflate(R.layout.test_question, null) );
            testQuestionConstructor.addRadio( 1, 3,3,getLayoutInflater().inflate(R.layout.test_question, null) );
            testQuestionConstructor.addRadio( 2, 6,3,getLayoutInflater().inflate(R.layout.test_question, null) );
            testQuestionConstructor.addRadio( 3, 9,3,getLayoutInflater().inflate(R.layout.test_question, null) );
            testQuestionConstructor.addRadio( 4, 12,3,getLayoutInflater().inflate(R.layout.test_question, null) );

            /*** Test Activity - Radio Add end **/

            /***  Button configurations ***/

            View buttonTest2 = getLayoutInflater().inflate(R.layout.button, null);

            Button buttonNext = buttonTest2.findViewById(R.id.button_next);
            Button buttonPrevious = buttonTest2.findViewById(R.id.button_previous);

            buttonPrevious.setVisibility( View.GONE );

            buttonNext.setOnClickListener( new View.OnClickListener(){
                public void onClick(View arg0){
                    //Start new activity class
                    Intent myIntent=new Intent(Test1Activity.this,Test2Activity.class);
                    startActivity(myIntent);
                }
            } );

            layout.addView(buttonTest2);


            /***  Button configurations End  ***/


        }


    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        Log.e("Radio - id : ", String.valueOf(view.getId()));

    }
}
