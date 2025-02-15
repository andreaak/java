package com.java._02_Classes._10_Anonymous;

public class ConcreteClass implements Interface {
    protected int protectedField = 10;

    public void method() {
        System.out.println("ConcreteClass: method()");
    }

    public int getValue() {
        return protectedField;
    }

    public ConcreteClass() {
    }

    public ConcreteClass(int i) {
        this.protectedField = i;
    }
}

