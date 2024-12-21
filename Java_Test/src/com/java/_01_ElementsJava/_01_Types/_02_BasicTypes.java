package com.java._01_ElementsJava._01_Types;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _02_BasicTypes {

    @Test
    public void Tst() {
        // ЦЕЛЫЕ ТИПЫ

        // 8-bits == 1 byte. ----------------------------------------------------------------------------
        // Целое со знаком. Диапазон - от -128 до +127.
        byte a = -128;
        byte b = +127;
        System.out.println(a);
        System.out.println(b);

        // 16-bits == 2 bytes. -------------------------------------------------------------------------
        // Целое со знаком. Диапазон - от -32768 до +32767.
        short c = -32768;
        short d = +32767;
        System.out.println(c);
        System.out.println(d);

        // 32-bits = 4 bytes. ---------------------------------------------------------------------------
        // Целое со знаком. Диапазон - от -2147483648 до +2147483647.
        int e = -2147483648;
        int f = +2147483647;
        System.out.println(e);
        System.out.println(f);

        // 64-bits = 8 bytes. ---------------------------------------------------------------------------
        // Целое со знаком. Диапазон - от -9223372036854775808 до +9223372036854775807.
        long g = -9223372036854775808L;
        long h = +9223372036854775807L;
        System.out.println(g);
        System.out.println(h);

        // ВЕЩЕСТВЕННЫЕ ТИПЫ
        // Вещественные типы предназначены для представления дробных чисел.

        // 32-bits = 4 bytes. ---------------------------------------------------------------------------
        // Вещественное со знаком. Диапазон - от +/-1.5 x 10^-45 до +/-3.4 x 10^38.
        // 7-8 символов
        float i = -0.123456789f; // Указание суффикса f, является обязательным,
        float j = +1.123456789F; // т.к., компилятор интерпретирует данное число как double.
        float j2 = +1111.123456789F;
        System.out.println(i);
        System.out.println(j);
        System.out.println(j2);
        /*
        -0.12345679
		1.1234568
		1111.1234
        */

        // 64-bits = 8 bytes. ---------------------------------------------------------------------------
        // Вещественное со знаком. Диапазон - от +/-5.0 x 10^-324 до +/-1.7 x 10^308.
        // 16-17 символов
        double k = -0.123456789123456789d;
        double l = +1.123456789123456789;
        double l2 = +1111.123456789123456789;
        System.out.println(k);
        System.out.println(l);
        System.out.println(l2);
        /*
        -0.12345678912345678
		1.1234567891234568
		1111.1234567891236
        */

        // ЛОГИЧЕСКИЙ ТИП
        // 8-bits == 1 byte. ----------------------------------------------------------------------------
        // Логическая величина Истина/Ложь.
        boolean m = true;
        boolean n = false;
        System.out.println(m);
        System.out.println(n);
        /*
        true
		false 
        */

        //СИМВОЛЬНЫЙ ТИП
        // 16-bits == 2 bytes. -------------------------------------------------------------------------
        // Символ в формате UNICODE.
        char o = 'a';
        char p = 'A';
        System.out.println(o);
        System.out.println(p);


        Object obj = null;
        System.out.println(obj);
        /*
        null 
        */

        // СТРОКОВОЙ ТИП
        // Строка в формате UNICODE.

        String firstString = "hello";
        String secondString = "HELLO";
        System.out.println(firstString);
        System.out.println(secondString);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
