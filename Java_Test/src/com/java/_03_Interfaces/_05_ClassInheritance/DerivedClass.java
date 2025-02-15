package com.java._03_Interfaces._05_ClassInheritance;

class BaseClass {
    public void method() {
        System.out.println("BaseClass.method()");
    }
}

public class DerivedClass extends BaseClass implements InterfaceClassInheritance {
    // Реализация интерфейса не обязательна, т.к.,
    // сигнатуры методов в классе и интерфейсе совпадают.

    public void method() {
        System.out.println("DerivedClass.method()");
    }

    public void method2() {
        System.out.println("DerivedClass.method2()");
    }
}

