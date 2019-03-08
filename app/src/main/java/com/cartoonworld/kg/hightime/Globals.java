package com.cartoonworld.kg.hightime;

public class Globals{
    private static Globals instance;

    // Global variable
    private int data;
    private String instructionActivityId;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setInstructionActivityId(String id){
        this.instructionActivityId=id;
    }
    public String getInstructionActivityId(){
        return this.instructionActivityId;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}