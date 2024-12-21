package com.java._02_Classes._05_Inheritance;

import org.junit.Test;

/**
 * Наследование.
 * <p>
 * Наследование — механизм объектно-ориентированного программирования, позволяющий описать новый (производный) класс
 * на основе уже существующего (базового),
 * при этом свойства и функциональность базового класса заимствуются новым производным классом.
 * <p>
 * Базовый класс             -                Производный  класс
 * Супер класс               -                Подкласс или (сабкласс)
 * Родительский класс        -                Дочерний класс
 * Родитель                  -                Потомок
 */
public class Main {

    @Test
    public void Test1() {
        DerivedClass instance = new DerivedClass();
        System.out.println(instance.publicField);
        System.out.println(instance.protectedField);
        //System.out.println(instance.privateField);
        instance.show();
        /*
        DerivedClass.publicField
        DerivedClass.protectedField
        BaseClass.privateField
         */
    }

    @Test
    public void Test2() {
        DerivedClass b = new DerivedClass();
        /*
        BaseClass.Static var a
        BaseClass.Static initializer
        DerivedClass.Static var a
        DerivedClass.Static initializer
        BaseClass.Var b
        BaseClass StaticMethod c
        BaseClass.Initializer
        BaseClass.Ctor1
        DerivedClass.Var b
        DerivedClass StaticMethod c
        DerivedClass.Initializer
        DerivedClass.Ctor1
        */
        DerivedClass b2 = new DerivedClass(1);
        /*
        BaseClass.Var b
        BaseClass StaticMethod c
        BaseClass.Initializer
        BaseClass.Ctor2
        DerivedClass.Var b
        DerivedClass StaticMethod c
        DerivedClass.Initializer
        DerivedClass.Ctor2
        */
    }

    @Test
    public void Test3() {
        DerivedClass tstB = new DerivedClass();
        System.out.println("DerivedClass tst = new DerivedClass().b = " + tstB.b);//2

        BaseClass tstA = tstB;
        System.out.println("BaseClass tst = new DerivedClass().b = " + tstA.b);//1

        System.out.println("DerivedClass.a = " + DerivedClass.a);//21
        System.out.println("tstB.b = " + tstB.a);//21
        System.out.println("tstA.c = " + tstA.a);//10


        System.out.println("tstB.e = " + tstB.e);//2
        System.out.println("tstA.e = " + tstA.e);//1
    }

    @Test
    public void Test4() {
        DerivedClass instance = new DerivedClass();
        instance.method();
        instance.staticMethod();

        // UpCast
        BaseClass instanceUp = instance;
        instanceUp.method();
        instance.staticMethod();

        // DownCast
        DerivedClass instanceDown = (DerivedClass) instanceUp;
        instanceDown.method();

        BaseClass.staticMethod();
        DerivedClass.staticMethod();

        /*
        method from DerivedClass
        staticMethod from DerivedClass
        method from DerivedClass
        staticMethod from DerivedClass
        method from DerivedClass
        staticMethod from BaseClass
        staticMethod from DerivedClass
         */
    }
}
