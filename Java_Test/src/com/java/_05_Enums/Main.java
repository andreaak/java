package com.java._05_Enums;

import org.junit.Test;

/*
Перечисление – это список именованных констант. Перечисления
могут иметь методы, конструкторы и переменные экземпляра.

Чтобы использовать экземпляр перечисляемого типа, необходимо
создать переменную этого типа и присвоить ей одно из значений
Можно объявить переменную перечислительного типа (enum), которой можно будет присвоить
ТОЛЬКО значения, объявленные в этом типе.

Java перечисления могут иметь конструкторы, методы и переменные экземпляра.
 */

public class Main {

    @Test
    public void Test1() {
        // Объект со ссылкой на экземпляр перечисляемого типа Day.
        Day today = Day.SATURDAY;
        System.out.println("Today is " + today);

        int number = 4;
        // Нельзя присвоить значение целого типа.
        // today = number;
        // today = 4;
    }

    @Test
    public void Test2() {
        // Нельзя переопределить єкземпляр перечисляемого типа.
        // Day.MONDAY = Day.FRIDAY;

        Day today = Day.SATURDAY;
        switch (today) {
            case SATURDAY:
                System.out.println("First day of the weekend - Saturday.");
                break;
            case SUNDAY:
                System.out.println("The last day of the weekend - Sunday.");
                break;
            default:
                System.out.println("The weekday - " + today);
        }

        // Также, можно сравнивать экземпляры перечисляеміх типов, используя операцию ==
        if (today == Day.SATURDAY) {
            System.out.println("Finally, weekend!");
        }
   }

    @Test
    public void Test3CtorAndMethods() {
        CompanyCtorAndMethods myComp = CompanyCtorAndMethods.ITVDN;
        System.out.println("Я работаю в компании " + myComp + " и зарабатываю " + myComp.getValue() + "$ в месяц.");
    }


    @Test
    public void Test4AbstractMethod() {
        // Объект со ссылкой на экземпляр перечисляемого типа CompanyAbstractMethod.
        CompanyAbstractMethod myComp = CompanyAbstractMethod.ITVDN;
        System.out.println(myComp);

        // Вызов методов.
        int salary = myComp.getValue();
        String currency = myComp.getCurrency();
        System.out.println("Я зарабатываю " + salary + " " + currency + " в месяц");

        /*
        CompanyAbstractMethod: ITVDN, salary = 1010 dollars
        Я зарабатываю 1010 dollars в месяц
        */
    }

}