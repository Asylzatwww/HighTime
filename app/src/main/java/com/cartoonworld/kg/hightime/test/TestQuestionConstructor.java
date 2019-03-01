package com.cartoonworld.kg.hightime.test;

import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cartoonworld.kg.hightime.R;

public class TestQuestionConstructor {

    String[] questionDescriptopion = {  };
    String[] questionText = {  };
    LinearLayoutCompat layout;

    public TestQuestionConstructor(LinearLayoutCompat layout, String[] questionDescriptopion, String[] questionText){
        this.questionDescriptopion = questionDescriptopion;
        this.questionText = questionText;
        this.layout = layout;
    }

    public void addRadio(int quesIndex, View child){


        RadioButton radio_quest2_1 = child.findViewById(R.id.radio_quest1);
        RadioButton radio_quest2_2 = child.findViewById(R.id.radio_quest2);
        RadioButton radio_quest2_3 = child.findViewById(R.id.radio_quest3);

        TextView test1text = child.findViewById(R.id.test1text);

        test1text.setText( questionDescriptopion[ quesIndex ] );

        quesIndex = quesIndex * 3;
        radio_quest2_1.setText( questionText[ quesIndex ] );
        radio_quest2_1.setId( 1 + quesIndex );
        radio_quest2_2.setText( questionText[ quesIndex + 1 ] );
        radio_quest2_2.setId( 2 + quesIndex );
        radio_quest2_3.setText( questionText[ quesIndex + 2 ] );
        radio_quest2_3.setId( 3 + quesIndex );

        layout.addView(child);
    }


}
