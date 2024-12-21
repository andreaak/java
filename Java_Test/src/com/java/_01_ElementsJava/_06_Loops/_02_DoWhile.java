package com.java._01_ElementsJava._06_Loops;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_DoWhile {
    // Циклическая конструкция - do-while.

    @Test
    public void TstDoWhile() {
        int counter = 0;

        do {
            counter++;
            System.out.println("Counter " + counter);
        }
        while (counter < 3);

        System.out.println("Произведено " + counter + " итераций.");
    }

    // Циклическая конструкция - do-while. (с досрочным выходом из цикла - break)

    @Test
    public void TstDoWhileBreak() {
        int counter = 0;

        do {
            counter++;
            System.out.println("Counter " + counter);

            if (true) break;
            System.out.println("Эта строка не выполнится.");
        }
        while (counter < 3);

        System.out.println("Произведено " + counter + " итераций.");
    }

    @Test
    public void TstDoWhileContinue() {
        int counter = 0;

        do {
            counter++;
            System.out.println("Counter " + counter);

            if (true) continue;

            System.out.println("Эта строка не выполнится.");
        } while (counter < 3);

        System.out.println("Произведено " + counter + " итераций.");
    }
}
