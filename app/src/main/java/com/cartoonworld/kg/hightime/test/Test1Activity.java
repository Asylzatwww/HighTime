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
import com.cartoonworld.kg.hightime.InstructionActivity;
import com.cartoonworld.kg.hightime.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test1Activity extends AppCompatActivity {

    public boolean nextBtnShow = true;
    public LinearLayoutCompat layout;


    public void questConstrfromLocal(int loopFrom, int loopTo, int answerLength, int answerStart){

        Resources res = getResources();
        String[] questionDescriptopion = res.getStringArray(R.array.quesDesc);
        String[] questionText = res.getStringArray(R.array.questTest);

        TestQuestionConstructor testQuestionConstructor = new TestQuestionConstructor(layout,
                questionDescriptopion, questionText);

        for (int i=loopFrom; i< loopTo; i++) {
            testQuestionConstructor.addRadio(i, answerStart, answerLength,
                    getLayoutInflater().inflate(R.layout.test_question, null));
            answerStart += answerLength;
        }

    }


    public void questConstrfromJson(int loopFrom, int loopTo){


        Globals g = Globals.getInstance();
        String[] questionDescriptopion = g.getQuestionDescriptopion();
        String[] questionText = g.getQuestionText();
        int[] answerStart = g.getAnswerStart();
        int[] answerLength = g.getAnswerLength();
        int questLength;

        if (questionDescriptopion.length <= loopTo) {
            questLength = questionDescriptopion.length;
            nextBtnShow = false;
        } else {
            questLength = loopTo;
        }


        Log.e("Test Array String : ", g.getTestsArray() );

        TestQuestionConstructor testQuestionConstructor = new TestQuestionConstructor(layout,
                questionDescriptopion, questionText );

        for (int i=loopFrom; i< questLength; i++) {
            testQuestionConstructor.addRadio(i, answerStart[i], answerLength[i],
                    getLayoutInflater().inflate(R.layout.test_question, null));
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        layout = (LinearLayoutCompat) findViewById(R.id.testLayout);

        if (getIntent().hasExtra("EXTRA_TEST_FROM_SERVER")){

            questConstrfromJson(0,5);

        } else {

            questConstrfromLocal(0,5,3, 0);
        }

        View buttonTest2 = getLayoutInflater().inflate(R.layout.button, null);

        Button buttonNext = buttonTest2.findViewById(R.id.button_next);
        Button buttonPrevious = buttonTest2.findViewById(R.id.button_previous);

        buttonPrevious.setVisibility( View.GONE );


        if (getIntent().hasExtra("EXTRA_TEST_FROM_SERVER")){

            if (nextBtnShow)
                buttonNext.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){
                        Intent myIntent=new Intent(Test1Activity.this,Test2Activity.class);
                        myIntent.putExtra("EXTRA_TEST_FROM_SERVER", "true"  );
                        startActivity(myIntent);
                    }
                } );
            else
                buttonNext.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){
                        Intent myIntent=new Intent(Test1Activity.this, InstructionActivity.class);
                        myIntent.putExtra("EXTRA_TEST_FROM_SERVER", "true"  );
                        startActivity(myIntent);
                    }
                } );


        } else {

            buttonNext.setOnClickListener( new View.OnClickListener(){
                public void onClick(View arg0){
                    Intent myIntent=new Intent(Test1Activity.this,Test2Activity.class);
                    startActivity(myIntent);
                }
            } );
        }

        layout.addView(buttonTest2);

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        Log.e("Radio - id : ", String.valueOf(view.getId()));

    }
}
