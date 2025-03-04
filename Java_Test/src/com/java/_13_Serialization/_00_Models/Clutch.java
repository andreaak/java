package com.java._13_Serialization._00_Models;

import java.io.Serializable;

public class Clutch implements Serializable {
    private int power;
    private String producer;

    public Clutch( int power, String producer ) {
        this.power = power;
        this.producer = producer;
        System.out.println("Clutch Constructor");
    }

    @Override
    public String toString() {
        return "Clutch{" +
                "power=" + power +
                ", producer='" + producer + '\'' +
                '}';
    }
}
