package com.java._02_Classes._13_References;

// класс Car явно наследуется от класса Object
class Car {

    // создаем поля
    private int speed;
    private String color;

    // конструктор
    public Car(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize");
    }
}