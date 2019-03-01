package com.cartoonworld.kg.hightime.test;

import android.content.Context;
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

import com.cartoonworld.kg.hightime.R;

public class Test1Activity extends AppCompatActivity {

    String[] questionDescriptopion = {  };
    String[] questionText = {  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);


        LinearLayoutCompat layout = (LinearLayoutCompat) findViewById(R.id.testLayout);

        View child = getLayoutInflater().inflate(R.layout.test_question, null);


        Resources res = getResources();
        questionDescriptopion = res.getStringArray(R.array.quesDesc);
        questionText = res.getStringArray(R.array.questTest);



        addRadio(layout, 0);
        addRadio(layout, 1);
        addRadio(layout, 2);
        addRadio(layout, 3);
        addRadio(layout, 4);


        View buttonTest2 = getLayoutInflater().inflate(R.layout.button, null);

        layout.addView(buttonTest2);

    }

    public void addRadio(LinearLayoutCompat layout, int quesIndex){
        View child2 = getLayoutInflater().inflate(R.layout.test_question, null);

        RadioButton radio_quest2_1 = child2.findViewById(R.id.radio_quest1);
        RadioButton radio_quest2_2 = child2.findViewById(R.id.radio_quest2);
        RadioButton radio_quest2_3 = child2.findViewById(R.id.radio_quest3);

        TextView test1text = child2.findViewById(R.id.test1text);

        test1text.setText( questionDescriptopion[ quesIndex ] );

        quesIndex = quesIndex * 3;
        radio_quest2_1.setText( questionText[ quesIndex ] );
        radio_quest2_1.setId( 1 + quesIndex );
        radio_quest2_2.setText( questionText[ quesIndex + 1 ] );
        radio_quest2_2.setId( 2 + quesIndex );
        radio_quest2_3.setText( questionText[ quesIndex + 2 ] );
        radio_quest2_3.setId( 3 + quesIndex );

        layout.addView(child2);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        Log.e("Radio - id : ", String.valueOf(view.getId()));

        // Check which radio button was clicked
        /*switch(view.getId()) {
            case 1:
                Log.e("M - ", "1");
                break;
            case 2:
                Log.e("M - ", "2");
                break;
            case 3:
                Log.e("M - ", "3");
                break;
            case 4:
                Log.e("M - ", "4");
                break;
            case 5:
                Log.e("M - ", "5");
                break;
            case 6:
                Log.e("M - ", "6");
                break;
        }*/
    }
}
