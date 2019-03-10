package com.cartoonworld.kg.hightime.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.cartoonworld.kg.hightime.InstructionActivity;
import com.cartoonworld.kg.hightime.R;

public class Test8Activity extends Test1Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        layout = (LinearLayoutCompat) findViewById(R.id.testLayout);

        if (getIntent().hasExtra("EXTRA_TEST_FROM_SERVER")) {

            questConstrfromJson(35, 40);


            /***  Button configurations ***/

            View buttonTest2 = getLayoutInflater().inflate(R.layout.button, null);

            Button buttonNext = buttonTest2.findViewById(R.id.button_next);
            Button buttonPrevious = buttonTest2.findViewById(R.id.button_previous);

            //buttonPrevious.setVisibility( View.GONE );

            buttonPrevious.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent myIntent = new Intent(Test8Activity.this, Test7Activity.class);
                    myIntent.putExtra("EXTRA_TEST_FROM_SERVER", "true");
                    startActivity(myIntent);
                }
            });

            /*if (nextBtnShow)
                buttonNext.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){
                        Intent myIntent=new Intent(Test8Activity.this,Test9Activity.class);
                        myIntent.putExtra("EXTRA_TEST_FROM_SERVER", "true"  );
                        startActivity(myIntent);
                    }
                } );
            else*/
                buttonNext.setOnClickListener( new View.OnClickListener(){
                    public void onClick(View arg0){
                        Intent myIntent=new Intent(Test8Activity.this, InstructionActivity.class);
                        myIntent.putExtra("EXTRA_TEST_FROM_SERVER", "true"  );
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
