package com.java._02_Classes._11_Object;

// класс Car явно наследуется от класса Object
class Car extends Object {

    // создаем поля
    private int speed;
    private String color;

    // конструктор
    public Car(int speed, String color) {
        super();
        this.speed = speed;
        this.color = color;
    }

    // изначально он выглядит как указано ниже и возвращает место занимаемое объектом в памяти
//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize");
    }
}