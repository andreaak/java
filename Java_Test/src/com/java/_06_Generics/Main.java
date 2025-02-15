package com.java._06_Generics;

import com.java._06_Generics._01_Base.GenericClass;
import com.java._06_Generics._01_Base.GenericMultyArgumentClass;
import com.java._06_Generics._02_Method.GenericMethod;
import com.java._06_Generics._04_Wildcards.NumericFns;
import org.junit.Test;

public class Main {

    @Test
    public void Test1GenericClass() {
        // Создаем экземпляр класса MyClass и в качестве параметра типа (тип MyClass) передаем тип String.
        GenericClass<String> instance1 = new GenericClass<String>();
        instance1.field = "ABC";
        instance1.method();

        // В качестве параметра типа передавать примитивные типы (int, long, float, double, и так далее) нельзя.
        //MyClass<int> instance2 = new MyClass<int>();
        //instance2.method();

        // Создаем экземпляр класса MyClass и в качестве параметра типа (тип MyClass) передаем тип Integer.
        GenericClass<Integer> instance2 = new GenericClass<Integer>();
        instance2.field = 1234;
        instance2.method();
    }

    @Test
    public void Test2GenericClass() {
        GenericMultyArgumentClass<Integer, Integer> instance1 = new GenericMultyArgumentClass<>(1, 2);
        System.out.println(instance1.variable1 + instance1.variable2);

        GenericMultyArgumentClass<String, Integer> instance2 = new GenericMultyArgumentClass<>("Number ", 1);
        System.out.println(instance2.variable1 + instance2.variable2);

        GenericMultyArgumentClass<String, String> instance3 = new GenericMultyArgumentClass<>("Hello ", "World");
        System.out.println(instance3.variable1 + instance3.variable2);
    }

    @Test
    public void Test3GenericMethod() {
        GenericMethod instance = new GenericMethod();

        instance.method("Hello world!");
    }

    @Test
    public void Test4Wildcards() {
        NumericFns<Integer> iOb = new NumericFns<Integer>(6);
        NumericFns<Double> dOb = new NumericFns<Double>(-6.0);
        NumericFns<Long> lOb = new NumericFns<Long>(5L);

        System.out.println("Сравнение iOb и dOb.");
        if (iOb.absEqual(dOb))
            System.out.println("Абсолютные значения одинаковы .");
        else
            System.out.println("Абсолютные значения отличаются.");

        System.out.println("Сравнение iOb и lOb.");
        if (iOb.absEqual(lOb))
            System.out.println("Абсолютные значения одинаковы .");
        else
            System.out.println("Абсолютные значения отличаются.");
    }
}
