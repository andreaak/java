package com.java._01_ElementsJava._07_Methods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Scanner;

@RunWith(JUnit4.class)
public class _01_Methods {
    // Методы.

    // На 9-й строке, создаем метод с именем procedure, который ничего не принимает и ничего не возвращает.
    // В теле метода, на 10-й строке выводим на экран строку - Hello!

    static void procedure() {
        System.out.println("Hello!");
    }

    // Методы (Функции).
    // На 9-й строке, создаем метод с именем function, который ничего не принимает и возвращает строковое значение.
    // В теле метода, используя ключевое слово return, возвращаем строку - Hello!

    static void print(int a) {
        System.out.println(a);
    }

    static void print(String name) {
        System.out.println(name);
    }

    static String function() {
        String word = "Hello!";
        return word;
    }

    // Пример правильного множественного возврата из метода.
    static String compare(int value1, int value2) {
        if (value1 < value2) {
            return "Comparison Less Than";
        } else if (value1 > value2) {
            return "Comparison Greater Than";
        }
        return "Comparison Equal";
    }

    // Пример: Использование сторожевого оператора, для защиты номинального варианта.
    static String function(String name) {
        // Выполняем проверку. При обнаружении ошибок завершаем работу.

        if (name == "fool") {  // Сторожевой оператор.
            return "Вы использовали недопустимое слово.";
        }

        // Код номинального варианта.

        String sentence = "Hello " + name + "!";

        return sentence;
    }

    // Параметр, передаваемый по значению, уничтожается при возврате значения методом
    static int addTwo(int a) {
        a = a + 2;
        System.out.println("Значение int a = " + a);
        return a;
    }

    static void recursion(int counter) {
        counter--;

        System.out.println("Первая половина метода: " + counter);

        if (counter != 0)
            recursion(counter);

        System.out.println("Вторая половина метода: " + counter);
    }

    static void recursion2(int counter) {
        counter--;

        System.out.println("Первая половина метода recursion: " + counter);

        if (counter != 0)
            method(counter);

        System.out.println("Вторая половина метода recursion: " + counter);
    }

    static void method(int counter) {
        System.out.println("Первая половина метода method: " + counter);

        recursion2(counter);

        System.out.println("Вторая половина метода method: " + counter);
    }

    @Test
    public void Tst1() {

        // В теле метода Main на 17-й строке, вызываем метод procedure.
        procedure();

        // В теле метода Main на 15-й строке, создаем строковую локальную переменную с именем string
        // и присваиваем ей возвращаемое значение метода function.

        print("hi");

        // В теле метода Main на 15-й строке, создаем строковую локальную переменную с именем string
        // и присваиваем ей возвращаемое значение метода function.

        //String string = function();
        System.out.println(function());
    }

    // Рекурсия (простая рекурсия).
    // В теле метода recursion на 15-й строке рекурсивно вызывается метод recursion.
    // Простая рекурсия - вызов методом самого себя (самовызов). При каждом вызове строится новая копия метода.

    @Test
    public void Tst2() {

        int operand1 = 1, operand2 = 2;

        String result = compare(operand1, operand2);
        System.out.println(result);
    }

    @Test
    public void Tst3() {
        String sentence = function("fool");

        System.out.println(sentence);
    }

    @Test
    public void Tst4() {
        System.out.println("Введите число:");
        Scanner in = new Scanner(System.in);

        // Принимаем ввод от пользователя и преобразуем его в целочисленное значение

        String number = in.next();
        int result = Integer.parseInt(number);

        System.out.println("Значение result = " + result);
        result = 10;
        // В качестве аргумента передается не сама переменная - result, а её копия.
        result = addTwo(result);
        System.out.println(addTwo(result));
        System.out.println(result);
    }

    // Рекурсия (сложная рекурсия).
    // Сложная рекурсия -  вызов методом себя, через другой метод.

    @Test
    public void Tst5Recursion() {
        recursion(3);
    }

    @Test
    public void Tst6Recursion() {
        method(3);
    }

}
