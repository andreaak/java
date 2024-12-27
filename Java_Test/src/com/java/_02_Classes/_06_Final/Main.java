package com.java._02_Classes._06_Final;

import org.junit.Test;

/*
Модификатор final

• Поля не могут быть изменены, методы переопределены.
• Классы нельзя наследовать.
• Этот модификатор применяется только к классам, методам и переменным (также и к
локальным переменным).
• Аргументы методов, обозначенные как final, предназначены только для чтения, при попытке
изменения будет ошибка компиляции.
• Переменные final не инициализируются по умолчанию, им необходимо явно присвоить
значение при объявлении или в конструкторе, иначе – ошибка компиляции.
• Если final переменная содержит ссылку на объект, объект может быть изменен, но переменная
всегда будет ссылаться на тот же самый объект.
• Также это справедливо и для массивов, потому что массивы являются объектами, – массив
может быть изменен, а переменная всегда будет ссылаться на тот же самый массив.
• Если класс объявлен final и abstract (взаимоисключающие понятия), произойдет ошибка
компиляции.
• Так как final класс не может наследоваться, его методы никогда не могут быть переопределены.
 */

public class Main {

    @Test
    public void Test1Final() {
        FinalFields a = new FinalFields();
        System.out.println(a.a);
        System.out.println(a.b);
        System.out.println(a.c);
        System.out.println(a.e);
        /*
        3
        4
        5
        6
         */

        a = new FinalFields(9);
        System.out.println(a.a);
        System.out.println(a.b);
        System.out.println(a.c);
        System.out.println(a.e);
        /*
        3
        4
        9
        6
         */
    }

    @Test
    public void Test2FinalClass() {

        FinalClass instance = new FinalClass();
        instance.x = 100;
        instance.y = 200;

        System.out.println("x = " + instance.x + "y = " + instance.y);
    }

    @Test
    public void Test3FinalMethod() {

        DerivedClassFinalMethod instance2 = new DerivedClassFinalMethod();
        instance2.show();
        /*
        FinalClassMethod.show
        FinalClassMethod.show
         */
    }
}
