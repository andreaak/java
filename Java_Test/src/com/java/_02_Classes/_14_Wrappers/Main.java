package com.java._02_Classes._14_Wrappers;

import org.junit.Test;

public class Main {

    @Test
    public void Test1() {
        // Целочисленные обертки размером 1 байт помещаются в пул констант
        //Пул констант ограничен 1 байтом - -128...127
        Integer a = 10;
        Integer b = 10;

        Integer a1 = -128;
        Integer b1 = -128;

        Integer c = 128;
        Integer d = 128;

        Character c1 = 100;
        Character c2 = 100;

        System.out.println(a == b);
        System.out.println(a1 == b1);
        System.out.println(c == d);
        System.out.println(c1 == c2);
        /*
        true
        true
        false
        true
        */
    }

}


