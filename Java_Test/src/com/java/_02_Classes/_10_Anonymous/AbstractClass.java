package com.java._02_Classes._10_Anonymous;

public abstract class AbstractClass implements Interface {
    private int privateField = 9;
    protected int protectedField = 10;

    public void method() {
        System.out.println("ConcreteClass: method()");
    }

    public abstract int getValue();
}
