package com.java._03_Interfaces._02_MultiInterface;

public interface SomeInterface2 {
    void method2();
    //int methodSameName();

    static int staticMethod() {
        return 2;
    }

    default int defaultMethod() {
        System.out.println("SomeInterface2.defaultMethod");
        return 20;
    }
}

