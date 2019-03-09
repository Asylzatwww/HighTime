package com.cartoonworld.kg.hightime;

import org.json.JSONArray;

public class Globals{
    private static Globals instance;

    // Global variable
    private int data;
    private String instructionActivityId;
    private String testsArray;


    private String[] questionDescriptopion = {  };
    private String[] questionText = {  };
    private int[] answerStart = {  };
    private int[] answerLength = {  };

    public void setQuestionDescriptopion(String[] questionDescriptopion){
        this.questionDescriptopion=questionDescriptopion;
    }
    public String[] getQuestionDescriptopion(){
        return this.questionDescriptopion;
    }




    public void setQuestionText(String[] questionText){
        this.questionText=questionText;
    }
    public String[] getQuestionText(){
        return this.questionText;
    }



    public void setAnswerStart(int[] answerStart){
        this.answerStart=answerStart;
    }
    public int[] getAnswerStart(){
        return this.answerStart;
    }


    public void setAnswerLength(int[] answerLength){
        this.answerLength=answerLength;
    }
    public int[] getAnswerLength(){
        return this.answerLength;
    }





    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setInstructionActivityId(String id){
        this.instructionActivityId=id;
    }
    public String getInstructionActivityId(){
        return this.instructionActivityId;
    }

    public void setTestsArray(String testsArray){
        this.testsArray=testsArray;
    }
    public String getTestsArray(){
        return this.testsArray;
    }


    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}