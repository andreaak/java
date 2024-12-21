package com.patterns._03_Behavioral.interpreter;

public class ConstantExpression implements Expression{
    private Object value;
    
    public ConstantExpression(Object newValue){
        value = newValue;
    }
    
    public void interpret(Context c){
        c.addVariable(this, value);
    }
}