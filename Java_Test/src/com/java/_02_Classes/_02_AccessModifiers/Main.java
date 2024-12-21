package com.java._02_Classes._02_AccessModifiers;

import org.junit.Test;

public class Main {

    @Test
    public void TestAccessModifiers() {
        //Reference type || name of variable || "new" - Instantiation || Constructor
        Car car = new Car();

        ////////////////////
        {
            Car car1 = new Car("model", 125, 1995,  60);
            Car car2 = new Car();

            // вызываем метод класса Car через обьект car1
            car1.setMaxSpeed(140);
            int speed = car1.getMaxSpeed();
            System.out.println(speed);

            //public
            speed = car1.speed;
            System.out.println(speed);

            //default
            var year = car1.year;
            System.out.println(year);

            //protected is like default inside one package
            int maxSpeed = car1.maxSpeed;
            System.out.println(maxSpeed);

            //private
            //var model = car1.model;

            // вызываем метод класса Car через обьект car2
            // car2.maxSpeed; // к приватным не имеем доступа из других классов
            car2.setMaxSpeed(150);
            System.out.println(car2.getMaxSpeed());
        }
    }

    @Test
    public void Test3() {
        {
            String st1 = null;    // можно стрингу присвоить нал
            Car car1 = null;      // можно экземпляру класса присвоить нал
            // int i = null;      // нельзя в примитивный тип впихнуть нал

            String str2 = (String) null; // Нал поддается кастованию в другие типы
            Car car2 = (Car) null;

            System.out.println(null == null);      // true
            System.out.println(car1 == null);      // true
            System.out.println(str2.equals(null));

            car1.getMaxSpeed(); // NullPointerException (RuntimeException)
        }
    }
}
