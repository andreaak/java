package com.java._13_Serialization._03_SelfRealization;

import com.java._13_Serialization._00_Models.Clutch;
import com.java._13_Serialization._00_Models.Engine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Bmw extends Car implements Serializable {
    private int price;
    private String model;
    private Clutch clutch;//serializable
    private transient Engine engine;//not serializable

    Bmw(int weight, int price, String model, Engine engine, Clutch clutch) {
        super(weight);
        this.price = price;
        this.model = model;
        this.engine = engine;
        this.clutch = clutch;
        System.out.println("Bmw Constructor");
    }

    //Must be private
    private void writeObject( ObjectOutputStream oos) {
        try {
            // Все что можно записываем обычным способом
            oos.defaultWriteObject();
            // То что нормально записать не можем, то записываем напрямую через метод
            oos.writeInt(engine.getPower());
            oos.writeObject(engine.getProducer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Must be private
    private void readObject( ObjectInputStream ois) {
        try {
            // Все что можно считываем обычным способом
            ois.defaultReadObject();
            // То что записать не можем нормально, то считываем через метод readInt()
            this.engine = new Engine(ois.readInt(), (String) ois.readObject());//For transient field
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Bmw{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", clutch=" + clutch +
                ", weight=" + getWeight() +
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

