package com.java._03_Interfaces._02_MultiInterface;

public interface SomeInterface1 {
    void method1();
    //void methodSameName();

    static int staticMethod() {
        return 1;
    }

    default int defaultMethod() {
        System.out.println("SomeInterface1.defaultMethod");
        return 11;
    }

    default int defaultMethod2() {
        System.out.println("SomeInterface1.defaultMethod2");
        return 21;
    }
}
