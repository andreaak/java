package com.java.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NOD {
	
    // Нахождение наибольшего общего делителя (НОД) двух целых чисел
    @Test
	public void Test() {

        System.out.println("Нахождение наибольшего общего делителя двух целых чисел");

        int a = 676, b = 3676;

        System.out.println("a = " + a + ", b = " + b + ", НОД = " + calculate(a, b) + ";");
    }
	
    // Первый вариант
    static int calculate(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return calculate(b, a % b);
    }

    // Второй вариант решения
    static int calculate2(int a, int b) {
        while (b != 0)
            b = a % (a = b);
        return a;
    }
}
