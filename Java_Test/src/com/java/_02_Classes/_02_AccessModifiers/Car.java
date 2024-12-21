package com.java._02_Classes._02_AccessModifiers;

// access modifiers

public class Car {
    private String model;   // private access modifier
    protected int maxSpeed; // protected access modifier
    int year;               // default access modifier
    public int speed;       // public access modifier
    /*
    private – члены класса доступны только внутри класса;
    default (package-private, модификатор по умолчанию) – члены класса видны внутри пакета;
    protected – члены класса доступны внутри пакета и в наследниках;
    public – члены класс доступны всем.
    */
    public Car() {
    }

    public Car(String model, int maxSpeed, int year, int speed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.year = year;
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int getYear() {
        return year;
    }

    protected int getMaxSpeed2() {
        return maxSpeed;
    }
}
