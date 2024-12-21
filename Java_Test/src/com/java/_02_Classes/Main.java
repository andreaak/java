package com.java._02_Classes;

import com.java._02_Classes._02_AccessModifiers.Car;
import org.junit.Test;

public class Main {

    @Test
    public void TestAccessModifiers() {

        Car car1 = new Car("model", 125, 1995,  60);

        // вызываем метод класса Car через обьект car1
        car1.setMaxSpeed(140);
        int speed = car1.getMaxSpeed();
        System.out.println(speed);

        //public
        speed = car1.speed;
        System.out.println(speed);

        //default
        //var year = car1.year;
        //var year = car1.getYear();
        //System.out.println(year);

        //protected
        //int maxSpeed = car1.maxSpeed;
        //int maxSpeed = car1.getMaxSpeed2();
        //System.out.println(maxSpeed);

        //private
        //var model = car1.model;
    }
}
