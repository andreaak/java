package com.java._13_Serialization._01_Base;

import java.io.Serializable;

class Clutch implements Serializable {
    private int power;
    private String producer;

    Clutch( int power, String producer ) {
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
