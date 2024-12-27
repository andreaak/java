package com.java._06_Generics._02_Method;

public class GenericMethod {
    public <T> void method(T argument) {
        T variable = argument;

        System.out.println(variable);
    }
}
