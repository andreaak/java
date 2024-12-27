package com.java._03_Interfaces._01_Base;

public interface SomeInterface {
    //static variables
    int A = 1;//public static final
    public static final int B = 1;

    //methods
    void method();//by defalt is public and abstract
    public abstract void method2();

    static int staticMethod() {
        return 1;
    }

    default int defaultMethod() {
        return 2;
    }
}
