package com.java._03_Interfaces._03_Inheritance;

public interface ExtendsInterface1 {
    void method1();
    //void method();//Интерфейсы имеющие методы с одинаковой сигнатурой но разными возвр. значениями нельзя объявить

    default int defaultMethod() {
        System.out.println("ExtendsInterface1.defaultMethod");
        return 1;
    }
}
