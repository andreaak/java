package com.java._02_Classes._06_Final;

import org.junit.Test;

public class Main {

    @Test
    public void Test1Static() {

        // вызов статического метода с помощью класса
        FinalFieldsAndMethods.doSmth(); // через Класс
        FinalFieldsAndMethods an = new FinalFieldsAndMethods();
        an.doSmth();
        //doSmth();      // в самом классе, без использованияя класса

        // вызов не статического метода или поля из статического контекста запрещено и приводит к ошибке компиляции
        // System.out.println(Main.count);

        FinalFieldsAndMethods a = new FinalFieldsAndMethods(2);
        System.out.println(a.a);
        System.out.println(a.b);
        FinalFieldsAndMethods a2 = new FinalFieldsAndMethods(9);
        System.out.println(a2.a);
        System.out.println(a2.b);
    }
}
