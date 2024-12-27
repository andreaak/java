package com.java._03_Interfaces._01_Base;

public class SomeClass implements SomeInterface {

    // Открытое поле
    public String publicField = "publicField";

    // Метод
    @Override
    public void method() {
        int a = A;
        a = SomeInterface.A;
        //A = 4;

        System.out.println("method.SomeClass");
    }

    @Override
    public void method2() {
        System.out.println("method2.SomeClass");
    }

//    @Override
//    protected void method2() {
//        System.out.println("method2.SomeClass");
//    }
}

