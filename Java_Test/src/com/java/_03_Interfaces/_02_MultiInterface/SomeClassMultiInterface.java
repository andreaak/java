package com.java._03_Interfaces._02_MultiInterface;

public class SomeClassMultiInterface implements SomeInterface1, SomeInterface2, SomeInterface3 {
    public void method1() {
        System.out.println("SomeClassMultiInterface.method1");
    }

    //Если не переопределить этот метод, то возникнет ошибка неопределенности
    @Override
    public int defaultMethod() {
        System.out.println("SomeClassMultiInterface.defaultMethod");
        return 4;
    }

    public void method2() {
        System.out.println("SomeClassMultiInterface.method2");
    }

    public void method3() {
        System.out.println("SomeClassMultiInterface.method3");
    }

    //Интерфейсы имеющие методы с одинаковой сигнатурой но разными возвр. значениями нельзя объявить
    //public void methodSameName() { System.out.println("methodSameName"); }
}
