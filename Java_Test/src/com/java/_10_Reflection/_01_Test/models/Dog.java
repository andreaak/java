package com.java._10_Reflection._01_Test.models;

public class Dog extends Animal implements Moving {
    public Dog(String name) {
        super(name);
    }

    @Override
    protected String getSound() {
        return "woff";
    }

    @Override
    public String eat() {
        return "bones";
    }

    @Override
    public String move() {
        return "walks";
    }
}
