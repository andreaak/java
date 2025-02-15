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
        _01_OuterClass.Nested instance = new _01_OuterClass().new Nested();
        instance.methodNested();
        instance.methodFromBaseNested();

        /*
        _01_OuterClass.methodOuter
        _01_OuterClass.methodOuterStatic
        Nested.methodNested
        BaseClassNested.methodFromBaseNested
         */
    }

    @Test
    public void Test2Inheritance() {
        _01_OuterClass instance1 = new _01_OuterClass();
        instance1.methodOuter();
        instance1.methodFromBaseClassOuter();

        _01_OuterClass.Nested instance = new _01_OuterClass().new Nested();
        instance.methodNested();
        instance.methodFromBaseNested();

        /*
        _01_OuterClass.methodOuter
        BaseClassOuter.methodFromBaseClassOuter
        _01_OuterClass.methodOuter
        _01_OuterClass.methodOuterStatic
        Nested.methodNested
        BaseClassNested.methodFromBaseNested
         */
    }

    @Test
    public void Test3StaticNested() {
        _02_OuterClassStatic.NestedStatic.staticMethodFromNested();

        _02_OuterClassStatic.NestedStatic instance = new _02_OuterClassStatic.NestedStatic();
        instance.staticMethodFromNested();

        /*
        _02_OuterClassStatic.methodOuterStatic
        NestedStatic.staticMethodFromNested
        _02_OuterClassStatic.methodOuterStatic
        NestedStatic.staticMethodFromNested
        */
    }
}