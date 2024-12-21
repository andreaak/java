package com.java._01_ElementsJava._03_Operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _06_Comparison {

    @Test
    public void Tst() {
        byte value1 = 0, value2 = 1;
        boolean result;

        // Less than
        result = value1 < value2;
        System.out.println(result);

        // Greater than
        result = value1 > value2;
        System.out.println(result);

        // Less than or equal to
        result = value1 <= value2;
        System.out.println(result);

        // Greater than or equal to
        result = value1 >= value2;
        System.out.println(result);

        // Equals
        result = value1 == value2;
        System.out.println(result);

        // Not equals
        result = value1 != value2;
        System.out.println(result);
    }

    @Test
    public void TstNonValid() {
        boolean result1;
        boolean result2;
        boolean result3;

        int a = 1;
        float b = 2.0f;
        result1 = a == b;   // Сравнение значения типа int, со значением типа float - допустимо.

        String c = "Hello";
        String d = "Hello";
        // result = c < a; // Сравнение значения типа int, со значением типа String - не допустимо.
        result2 = c.equals(a);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(c == d);

        char u = 0x0001;
        result3 = a < u;
        System.out.println(u);
        System.out.println(result3);
    }

}
