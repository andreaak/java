package com.java._04_Exceptions._03_Throws;

import org.junit.Test;

class MyClass {
    public void myMethod() throws Exception {
        Exception exception = new Exception("Мое исключение");
        throw exception;
    }
}

public class Main {
    @Test
    public void Test1() {
        try {
            MyClass instance = new MyClass();
            instance.myMethod();
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
    }
}