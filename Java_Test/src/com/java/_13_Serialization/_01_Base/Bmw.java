package com.java._13_Serialization._01_Base;

import com.java._13_Serialization._00_Models.Clutch;
import com.java._13_Serialization._00_Models.Engine;

import java.io.Serializable;

public class Bmw implements Serializable {
    //private static final long serialVersionUID = 25L;

    public static int testStatic;

    private int price;
    private String model;
    private Clutch clutch;//serializable
    private transient Engine engine;//not serializable

    Bmw(int price, String model, Engine engine, Clutch clutch) {
        this.price = price;
        this.model = model;
        this.engine = engine;
        this.clutch = clutch;
        testStatic = 45;
        System.out.println("Bmw Constructor");
    }

    @Override
    public String toString() {
        return "Bmw{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", clutch=" + clutch +
                ", testStatic=" + testStatic +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}