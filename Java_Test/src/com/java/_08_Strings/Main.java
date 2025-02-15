package com.java._08_Strings;

import org.junit.Test;

public class Main {

    @Test
    public void TestString1() {

        String s1 = "World";   // pool
        String s2 = "World";   // pool

        // Создаем текст через конструктор
        String s3 = new String("World");
        String s4 = new String("World");
        System.out.println(s1 == s2);

        // Используя метод intern - мы помещаем в пул значения
        System.out.println(s1 == s3.intern());
        System.out.println(s3.intern() == s4.intern());
        System.out.println();

        Integer a = 10;
        Integer b = 10;
        Integer c1 = 128;
        Integer c2 = 128;
        // Целочисленные классы-обёртки свои значение помещают в pool, в пуле могут хранится числа от -128..127(1 byte)
        System.out.println(a == b);
        // Выходим за диапазон 1 байта и получаем результат отрицательный
        System.out.println(c1 == c2);
    }

    @Test
    public void TestString2Immutable() {
        String s1 = "Hello";
        String s2 = s1;
        System.out.println(s1 == s2);

        // Выполняем конкатенацию
        s1 += " World";
        s2 += " World";
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        /*
        true
        false
        Hello World
        Hello World
         */
    }

    @Test
    public void TestString3Pool() {
        // Значение заносим в пул
        String s1 = "World";   // pool
        String s2 = "World";   // pool

        // Создаем строковое значение через конструктор, в пул не помещаем
        String s3 = new String("World");
        String s4 = new String("World");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        Integer a = 10;
        Integer b = 10;
        Integer c1 = 128;
        Integer c2 = 128;
        Integer aNew = new Integer(10);
        Integer bNew = new Integer(10);
        System.out.println(aNew == bNew);
        // Целочисленные классы-обёртки свои значение помещают в pool, в пуле могут хранится числа от -128..127(1 byte)
        System.out.println(a == b);
        // Выходим за диапазон 1 байта и получаем результат отрицательный
        System.out.println(c1 == c2);
    }

    @Test
    public void TestString4StringBuffer() {
        String str1 = "У кота ";
        String str2 = " лапы";
        int paws = 4;
        StringBuffer sb = new StringBuffer(20);
        sb.append(str1).append(paws).append(str2);

        System.out.println("строка ->" + sb);
        System.out.println("длина ->" + sb.length());
        System.out.println("размер ->" + sb.capacity());
        System.out.println("реверс ->" + sb.reverse());
        //sb = "Java"; // ошибка, только для класса String можно через литерал создавать

        /*
        строка ->У кота 4 лапы
        длина ->13
        размер ->20
        реверс ->ыпал 4 аток У
         */
    }

    @Test
    public void TestString5StringBuilder() {
        String palindrome = "Dot saw I was Tod";
        StringBuilder sb = new StringBuilder(palindrome);
        sb.reverse();  // reverse it
        System.out.println(sb);
    }


}