package com.java._10_Reflection._01_Test.models;

public class Bird extends Animal {
    private boolean walks;

    public Bird() {
        super("bird");
    }

    public Bird(String name) {
        super(name);
    }

    public Bird(String name, boolean walks) {
        super(name);
        this.walks = walks;
    }

    @Override
    protected String getSound() {
        return "birdsong";
    }

    @Override
    public String eat() {
        return "grain";
    }

    public boolean isWalks() {
        return walks;
    }

    public void setWalks(boolean walks) {
        this.walks = walks;
    }

    private String getPrivate() {
        return "private";
    }
}
