package com.java._02_Classes._03_Packages;

import com.java._02_Classes._01_ClassDeclaration.Car;
import org.junit.Test;
import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class Main {
    @Test
    public void Test1() {
        // Если класс (Машина) лежит в другом пакете, то что бы его использовать в Классе Main - его надо импортировать
        Car myCar = new Car();

        // можно сам импорт не писать, а указать полное имя класса, который нам надо использовать.
        com.java._02_Classes._01_ClassDeclaration.Car myCar2 =
                new  com.java._02_Classes._01_ClassDeclaration.Car();


        // используем статические методы класса Math

        double number = 1;
        double result = Math.cos(Math.PI * number);

        // сделали статический импорт, что позволило нам оптимизировать код
        result = cos(PI * number);
    }
}
