package com.java._01_ElementsJava._07_Methods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_MethodsNamedArgs {
    // Именованные аргументы методов

    static int difference(int height, int width) {
        return height - width;
    }

    @Test
    public void Tst1() {
        // Можно вызвать метод так:
        int difference;
        difference = difference(6, 5);

        // difference = difference(5, 6);

        System.out.println("Разность равна: " + difference);
    }
}

