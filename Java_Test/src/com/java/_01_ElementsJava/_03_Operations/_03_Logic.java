package com.java._01_ElementsJava._03_Operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_Logic {
    // Побитовые логические операции.
    @Test
    public void Tst1() {
        byte operand1, operand2;
        int result;

        // Конъюнкция

        // Таблица истинности для операций Конъюнкции (И) - & - [AND]

        // Если хоть один из операндов имеет значение 0 - вся конструкция имеет значение 0. Иначе - 1

        //    0 & 0 = 0         1 & 0 = 0
        //    0 & 1 = 0         1 & 1 = 1

        operand1 = 127;                             // [0111 1111 Bin] = [FF Hex] = [127 Dec]
        operand2 = 1;                               // [0000 0001 Bin] = [01 Hex] = [01 Dec]
        result = operand1 & operand2;               // [0000 0001 Bin] = [01 Hex] = [01 Dec]

        System.out.println(operand1 + " AND " + operand2 + " = " + result);

        // Дизъюнкция

        // Таблица истинности для Дизъюнкции (ИЛИ) - | - [OR]

        // Если хоть один из операндов имеет значение 1 - вся конструкция имеет значение 1. Иначе - 0

        //    0 | 0 = 0         1 | 0 = 1
        //    0 | 1 = 1         1 | 1 = 1

        operand1 = 2;                       // [0000 0010 Bin] = [02 Hex] = [02 Dec]
        operand2 = 1;                       // [0000 0001 Bin] = [01 Hex] = [01 Dec]
        result = operand1 | operand2;       // [0000 0011 Bin] = [03 Hex] = [03 Dec]

        System.out.println(operand1 + " OR " + operand2 + " = " + result);

        // Исключающее ИЛИ

        // Таблица истинности для Исключающего ИЛИ - ^ - [XOR]

        // Если операнды имеют одинаковое значение - результат операции 0,
        // Если операнды разные - 1

        //    0 ^ 0 = 0         1 ^ 0 = 1
        //    1 ^ 1 = 0         0 ^ 1 = 1

        operand1 = 3;                               // [0000 0011 Bin] = [03 Hex] = [03 Dec]
        operand2 = 1;                               // [0000 0001 Bin] = [01 Hex] = [01 Dec]
        result = operand1 ^ operand2;               // [0000 0010 Bin] = [02 Hex] = [02 Dec]

        System.out.println(operand1 + " XOR " + operand2 + " = " + result);

        // Отрицание

        // Таблица истинности для Отрицания (НЕТ) - ~ - [NOT]

        // ~ 0  = 1
        // ~ 1  = 0

        operand1 = 1;             // [0000 0001] = [01 Dec]
        result = ~operand1;       // [1111 1110] = [-2 Dec]

        System.out.println("NOT " + operand1 + " = " + result);

        // Изменение знака числа

        // Формула изменения знака числа, с (+N) на (-N) или наоборот.

        // Для того, чтобы сменить знак числа, необходимо:
        // выполнить его отрицание, а результат увеличить на 1.

        //  ~  +N + 1 = -N
        //  ~  -N + 1 = +N

        operand1 = 1;                               // [0000 0001]
        result = ~operand1;                         // [1111 1110]
        result++;                                   // [1111 1111]

        System.out.println("NOT " + operand1 + " + 1 = " + result);
    }

    @Test
    public void Tst2() {
        boolean operand1 = false, operand2 = false, result = false;

        // Конъюнкция

        // Таблица истинности для Конъюнкции (И) - && - [AND]

        // Если хоть одно из выражений операции операции конъюнкции имеет значение false -
        // все выражение имеет значение false, иначе - true

        // false && false = false                  true && false = false
        // false && true = false                   true && true = true

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 && operand2;             // false

        System.out.println(operand1 + " AND " + operand2 + " = " + result);

        // Дизъюнкция

        // Таблица истинности для Дизъюнкции (ИЛИ) - || - [OR]

        // Если хоть одно из выражений операции операции Дизъюнкции имеет значение true -
        // все выражение имеет значение true, иначе - false

        // false || false = false                  true || false = true
        // false || true = true                    true || true = true

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 || operand2;             // true

        System.out.println(operand1 + " OR " + operand2 + " = " + result);

        // Исключающее ИЛИ

        // Таблица истинности для Исключающего ИЛИ - ^ - [XOR]

        // Если оба выражения операции Исключающего ИЛИ имеют одинакое значение -
        // все выражение имеет значение false, если разные - true

        // false ^ false = false                   true ^ false = true
        // false ^ true = true                     true ^ true = false

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 ^ operand2;              // true

        System.out.println(operand1 + " XOR " + operand2 + " = " + result);

        // Отрицание

        // Таблица истинности для Отрицания (НЕТ) - ! - [NOT]

        // !false  = true
        // !true  = false

        operand1 = true;
        result = !operand1;

        System.out.println("NOT " + operand1 + " = " + result);
    }

    // Логический Сдвиг  (shift).

    @Test
    public void Tst3() {
        byte operand = 0b0000001;              // 0000 0001
        System.out.println("Число до сдвига: " + operand);

        // Логический сдвиг числа влево.

        operand = (byte)(operand << 2);   // 0000 0100
        System.out.println("Число после сдвига влево: " + operand);

        // Логический сдвиг числа вправо.

        operand = (byte)(operand >> 1);   // 0000 0010

        System.out.println("Число после сдвига вправо: " + operand);
    }

    // Преобразования логических переменных в соответствии с теоремами Де Моргана.

    // Для применения теорем Де Моргана к логическому оператору AND или OR и паре операндов,
    // требуется инвертировать оба операнда, заменить (AND на OR) или (OR на AND) и
    // инвертировать все выражение полностью.

    //  Исходное выражение                           Эквивалентное выражение
    //     !A & !B                       =                  !(A | B)
    //     !A & B                        =                  !(A | !B)
    //     A & !B                        =                  !(!A | B)
    //     A & B                         =                  !(!A | !B)
    //     !A | !B                       =                  !(A & B)
    //     !A | B                        =                  !(A & !B)
    //     A | !B                        =                  !(!A & B)
    //     A | B                         =                  !(!A & !B)

    @Test
    public void Tst4() {
            boolean a = true;
            boolean b = false;

            // Условие до применения теоремы Де Моргана.
            if (!a || !b)
                System.out.println("!A || !B = " + (!a || !b));
            else
                System.out.println("!A || !B = " + (!a || !b));

            // Условие после применения теоремы Де Моргана.
            if (!(a && b))
                System.out.println("!(A && B) = " + !(a && b));
            else
                System.out.println("!(A && B) = " + !(a && b));
    }
}
