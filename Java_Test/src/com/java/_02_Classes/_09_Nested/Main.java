package com.java._02_Classes._09_Nested;

import org.junit.Test;

/*
Тип, определенный внутри класса или структуры, называется вложенным типом.

Экземпляр внутреннего класса не может существовать без привязки к включающему его классу верхнего уровня.
Статические классы могут в себе содержать нестатические Nested классы.
 */

public class Main {

    @Test
    public void Test1() {
        OuterClass.Nested instance = new OuterClass().new Nested();
        instance.methodNested();
        instance.methodFromBase();
    }

    @Test
    public void Test2Inheritance() {
        OuterClass instance1 = new OuterClass();
        instance1.methodOuter();
        instance1.methodFromBaseClassOuter();

        OuterClass.Nested instance = new OuterClass().new Nested();
        instance.methodNested();
        instance.methodFromBase();

        /*
        OuterClass.methodOuter
        BaseClassOuter.methodFromBase
        Nested.method
        BaseClass.methodFromBase
         */
    }

    @Test
    public void Test3StaticNested() {
        OuterClass.NestedStatic.staticMethodFromNested();

        OuterClass.NestedStatic instance = new OuterClass.NestedStatic();
        instance.staticMethodFromNested();

        /*
        NestedStatic.staticMethodFromNested
        NestedStatic.staticMethodFromNested
        */
    }
}