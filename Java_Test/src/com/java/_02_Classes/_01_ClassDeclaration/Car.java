package com.java._02_Classes._01_ClassDeclaration;

// Объявление класса (поля, конструктор, методы)

public class Car {
    private String model;
    private int maxSpeed;
    private int year;
    private int speed;

    public static int a = GetIntSt("Car.Static var a");
    public int b = GetInt("Car.Var b");

    public int e;

    static{
        System.out.println("Car.Static initializer");
    }

    {
        System.out.println("Car.Initializer");
        e = 1;
    }

    public Car() {
        System.out.println("Car.Ctor1");
    }

    public Car(String model, int maxSpeed, int year, int speed) {
        this.model = model;
        //this.maxSpeed = maxSpeed;
        this.year = year;
        this.speed = speed;
        System.out.println("Car.Ctor2");
    }

    private static int GetIntSt(String text) {
        System.out.println(text);
        return 10;
    }

    private int GetInt(String text) {
        System.out.println(text);
        return 1;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}