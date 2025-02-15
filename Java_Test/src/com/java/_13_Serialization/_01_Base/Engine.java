package com.java._13_Serialization._01_Base;

class Engine {
    private int power;
    private String producer;

    Engine( int power, String producer ) {
        this.power = power;
        this.producer = producer;
        System.out.println("Engine Constructor");
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                ", producer='" + producer + '\'' +
                '}';
    }

    public int getPower() {
        return power;
    }

    public String getProducer() {
        return producer;
    }
}

