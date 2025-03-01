package com.patterns._04_Other.callback;

public class Command implements java.io.Serializable{
    public static final int GET_PROJECT = 1;
    public static final int GET_TASK = 2;
    public static final int CREATE_CONTACT = 4;
    public static final int ADD_ADDRESS = 8;
    public static final int REMOVE_ADDRESS = 16;
    public static final int FINALIZE_CONTACT = 32;
    
    private int command;
    private Object [] arguments;
    
    public int getCommand(){
        return command;
    }
    
    public Object [] getArguments(){
        return arguments;
    }
    
    public void setArguments(Object [] newArguments){
        arguments = newArguments;
    }
    
    public void setCommand(int newCommand){
        command = newCommand;
    }
    
    public Command(int name, Object [] argumentList){
        command = name;
        arguments = argumentList;
    }
}