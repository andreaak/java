package com.java._07_Collections;

import java.util.Comparator;
import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private String name;
    private int cost;
    private boolean isRipe;

    public Fruit(String name, int cost, boolean isRipe) {
        this.name = name;
        this.cost = cost;
        this.isRipe = isRipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isRipe() {
        return isRipe;
    }

    public void setRipe(boolean ripe) {
        isRipe = ripe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return cost == fruit.cost && isRipe == fruit.isRipe && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, isRipe);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", isRipe=" + isRipe +
                '}';
    }

    @Override
    public int compareTo( Fruit o ) {
        return name.compareTo(o.name);
    }
}

class ComparatorByCost implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Fruit) o1).getCost() - ((Fruit) o2).getCost();
    }
}
