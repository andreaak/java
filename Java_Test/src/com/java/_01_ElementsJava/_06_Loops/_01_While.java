package com.java._01_ElementsJava._06_Loops;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _01_While {

    // Циклическая конструкция - while.
    @Test
    public void TstWhile() {
        int counter = 0;

        while (counter < 3) {
            counter++;
            System.out.println("Counter " + counter);
        }

        System.out.println("Произведено " + counter + " итераций.");
    }

    // Циклическая конструкция - while. (с досрочным выходом из цикла - break)
    @Test
    public void TstWhileBreak() {
        int counter = 0;

        while (counter < 3) {
            counter++;
            System.out.println("Counter " + counter);

            if (true) break;

            System.out.println("Эта строка не выполнится.");
        }

        System.out.println("Произведено " + counter + " итераций.");
    }

    // Циклическая конструкция - while. (с пропуском итерации - continue)
    @Test
    public void TstWhileContinue() {

        int counter = 0;

        while (counter < 3) {
            counter++;
            System.out.println("Counter " + counter);

            if (true) continue;

            System.out.println("Эта строка не выполнится.");
        }

        System.out.println("Произведено " + counter + " итераций.");
    }
}
