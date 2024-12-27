package com.java._02_Classes._01_ClassDeclaration;

import org.junit.Test;

public class Main {

    @Test
    public void Test1() {
        //Reference type || name of variable || "new" - Instantiation || Constructor
        Car car = new Car();
        /*
        Car.Static var a
        Car.Static initializer
        Car.Var b
        Car.Initializer
        Car.Ctor1
        */

        car = new Car("1", 2, 3, 4);
        /*
        Car.Var b
        Car.Initializer
        Car.Ctor2
        */
    }

    @Test
    public void Test2() {
        //Reference type || name of variable || "new" - Instantiation || Constructor
        Car car = new Car("1", 2, 3, 4);
        var t = car.getMaxSpeed();
    }

}
