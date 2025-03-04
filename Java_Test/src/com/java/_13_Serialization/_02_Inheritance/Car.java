package com.java._13_Serialization._02_Inheritance;

import java.io.Serializable;

public abstract class Car{

    private int weight = 10000;

    Car() {

        System.out.println("Car default Constructor");
    }

    Car(int weight) {
        System.out.println("Car Constructor");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }
}
