package com.java._02_Classes._12_Cloning._01_Deep;

import java.io.Serializable;

public class Cow implements Serializable {
    private String name;
    private int weight;
    private int age;

    public Cow() {
    }

    public Cow(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cow(Cow cow) {
        this.name = cow.name;
        this.weight = cow.weight;
        this.age = cow.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }

    public static Cow getCowInstance(String name, int weight, int age) {
        Cow instance = new Cow();
        instance.name = name;
        instance.weight = weight;
        instance.age = age;

        return instance;
    }

    public static Cow getCowInstance(Cow carToCopy) {
        Cow copiedCar = new Cow();
        copiedCar.name = carToCopy.name;
        copiedCar.weight = carToCopy.weight;
        copiedCar.age = carToCopy.age;
        return copiedCar;
    }
}
