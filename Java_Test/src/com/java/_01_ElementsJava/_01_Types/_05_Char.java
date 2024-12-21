package com.java._01_ElementsJava._01_Types;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _05_Char {

    @Test
    public void Tst() {
        char a = 'A';       // Символ
        char b = 0x0041;    // Значение в 16-ричном формате
        char c = '\u0065';  // Значение в формате unicode

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        int ff = 1 / 0;
        System.out.println(ff);
    }
}
