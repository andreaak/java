package com.java._08_Strings;

import org.junit.Test;

/*
Каждая строка, создаваемая с помощью оператора new или с помощью литерала (заключённая в двойные апострофы),
является объектом класса String.
Особенностью объекта класса String является то, что его значение не может быть изменено после создания объекта
при помощи какого-либо метода класса, так как любое изменение строки приводит к созданию нового объекта.
Классы StringBuilder и StringBuffer являются “близнецами” и по своему предназначению близки к классу String,
но, в отличие от последнего, содержимое и размеры объектов классов StringBuilder и StringBuffer можно изменять.
Основным и единственным отличием StringBuilder от StringBuffer является потокобезопасность последнего.
С помощью соответствующих методов и конструкторов объекты классов StringBuffer,
StringBuilder и String можно преобразовывать друг в друга.
Конструктор класса StringBuffer (также, как и StringBuilder) может принимать в качестве параметра объект String.

 1. Для перетворення рядка на число можна використати методи parseXXX класу обгортки
відповідного типу даних.
2. Наприклад, для цілих чисел можна використовувати метод Integer.parseInt ()(), для чисел з
плаваючою крапкою Double.parseDouble і т. д.
3. Для обробки можливих помилок можна використовувати конструкцію try catch або
перевіряти валідність рядка перед перетворенням за допомогою методів, наприклад,
Integer.parseInt кидає виключення NumberFormatException у разі некоректного
формату рядка.
4. Для перетворення числа на рядок можна використати метод String.valueOf або
конкатенацію рядків з числовими значеннями.
 */

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

        /*
        true
        true
        true

        true
        false
         */
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