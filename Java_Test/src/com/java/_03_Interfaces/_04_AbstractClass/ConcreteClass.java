package com.java._03_Interfaces._04_AbstractClass;

public class ConcreteClass extends AbstractClass {
    // Реализация абстрактного метода из абстрактного класса, в конкретном классе обязательна.
    public void method() {
        System.out.println("ConcreteClass.method");
    }

    public void method2() {
        System.out.println("ConcreteClass.method2");
    }
}

