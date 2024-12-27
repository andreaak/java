package com.java._03_Interfaces._03_Inheritance;

public interface ExtendsInterface2 {
    void method2();
    //int method();//Интерфейсы имеющие методы с одинаковой сигнатурой но разными возвр. значениями нельзя объявить

    default int defaultMethod() {
        System.out.println("ExtendsInterface2.defaultMethod");
        return 2;
    }
}

