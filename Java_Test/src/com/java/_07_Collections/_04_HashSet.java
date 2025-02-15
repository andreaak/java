package com.java._07_Collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _04_HashSet {

    @Test
    public void TestSet1(){
        Set<Fruit> set = new HashSet<>();
        set.add(new Fruit("mango", 50, true));
        set.add(new Fruit("apple", 15, false));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("orange", 35, true));

        for (Fruit fruit : set){
            System.out.println(fruit.getName());
        }

        set.remove(new Fruit("apple", 15, false));

        for (Fruit fruit : set){
            System.out.println(fruit.getName());
        }

        /*
        mango
        orange
        banana
        apple

        mango
        orange
        banana
         */

    }

    @Test
    public void TestSet2TreeSet(){
        Set<Fruit> set = new TreeSet<>();
        set.add(new Fruit("mango", 50, true));
        set.add(new Fruit("apple", 15, false));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("banana", 25, true));
        set.add(new Fruit("orange", 35, true));

        for (Fruit fruit : set){
            System.out.println(fruit.getName());
        }

        set.remove(new Fruit("apple", 15, false));

        for (Fruit fruit : set){
            System.out.println(fruit.getName());
        }

        /*
        apple
        banana
        mango
        orange

        banana
        mango
        orange
         */

    }
}
