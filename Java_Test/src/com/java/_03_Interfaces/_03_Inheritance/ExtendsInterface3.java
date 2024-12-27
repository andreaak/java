package com.java._03_Interfaces._03_Inheritance;

public interface ExtendsInterface3 extends ExtendsInterface1, ExtendsInterface2 {
    void method3();

    default int defaultMethod() {
        System.out.println("ExtendsInterface3.defaultMethod");
        return 3;
    }
}
