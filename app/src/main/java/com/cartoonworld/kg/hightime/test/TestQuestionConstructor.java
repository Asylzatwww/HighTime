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

    public void addRadio(int quesIndex, int answerStart, int answerLength, View child){


        RadioButton radio_quest2_1 = child.findViewById(R.id.radio_quest1);
        RadioButton radio_quest2_2 = child.findViewById(R.id.radio_quest2);
        RadioButton radio_quest2_3 = child.findViewById(R.id.radio_quest3);
        RadioButton radio_quest2_4 = child.findViewById(R.id.radio_quest4);
        RadioButton radio_quest2_5 = child.findViewById(R.id.radio_quest5);

        TextView test1text = child.findViewById(R.id.test1text);

        test1text.setText( questionDescriptopion[ quesIndex ] );

        quesIndex = quesIndex * 3;

        if (answerLength > 0) {
            radio_quest2_1.setText(questionText[answerStart]);
            radio_quest2_1.setId(1 + quesIndex);
        } else radio_quest2_1.setVisibility(View.GONE);

        if (answerLength > 1) {
            radio_quest2_2.setText( questionText[ answerStart + 1 ] );
            radio_quest2_2.setId( 2 + quesIndex );
        } else radio_quest2_2.setVisibility(View.GONE);

        if (answerLength > 2) {
            radio_quest2_3.setText( questionText[ answerStart + 2 ] );
            radio_quest2_3.setId( 3 + quesIndex );
        } else radio_quest2_3.setVisibility(View.GONE);

        if (answerLength > 3) {
            radio_quest2_4.setText( questionText[ answerStart + 3 ] );
            radio_quest2_4.setId( 4 + quesIndex );
        } else radio_quest2_4.setVisibility(View.GONE);

        if (answerLength > 4) {
            radio_quest2_5.setText( questionText[ answerStart + 4 ] );
            radio_quest2_5.setId( 5 + quesIndex );
        } else radio_quest2_5.setVisibility(View.GONE);

        layout.addView(child);
    }


}
