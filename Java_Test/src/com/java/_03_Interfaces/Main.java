package com.java._03_Interfaces;

import com.java._03_Interfaces._01_Base.SomeClass;
import com.java._03_Interfaces._01_Base.SomeInterface;
import com.java._03_Interfaces._02_MultiInterface.SomeClassMultiInterface;
import com.java._03_Interfaces._02_MultiInterface.SomeInterface1;
import com.java._03_Interfaces._02_MultiInterface.SomeInterface2;
import com.java._03_Interfaces._02_MultiInterface.SomeInterface3;
import com.java._03_Interfaces._03_Inheritance.ExtendsInterface1;
import com.java._03_Interfaces._03_Inheritance.ExtendsInterface2;
import com.java._03_Interfaces._03_Inheritance.ExtendsInterface3;
import com.java._03_Interfaces._03_Inheritance.SomeExtendsClass;
import com.java._03_Interfaces._04_AbstractClass.ConcreteClass;
import com.java._03_Interfaces._05_ClassInheritance.DerivedClass;
import com.java._03_Interfaces._05_ClassInheritance.InterfaceClassInheritance;
import org.junit.Test;


/*
Интерфейс – семантическая и синтаксическая конструкция в
коде программы, используемая для специфицирования услуг,
предоставляемых классом или компонентом.

Интерфейс-стереотип, являющийся аналогом чистого
абстрактного класса, в котором запрещена любая реализация.

Правила использования интерфейсов:
• Невозможно создать экземпляр интерфейса.
• Интерфейсы и члены интерфейсов являются абстрактными. Интерфейсы не имели реализации в Java до 8 версии.
• Интерфейс может содержать только абстрактные члены.
• Члены интерфейсов автоматически являются открытыми, абстрактными, и они не могут иметь модификаторов
доступа.
• Интерфейсы не могут содержать конструкторы экземпляров, вложенные типы (интерфейсы в том числе).
• Классы, которые реализуют интерфейс, должны реализовать члены этого интерфейса, указанные при его создании.
• Интерфейс может наследоваться от одного или нескольких базовых интерфейсов.
• Базовый класс также может реализовать члены интерфейса с помощью абстрактных членов. В этом случае
производный класс может изменить поведение интерфейса путем переопределения методов.
• Если класс реализует два интерфейса, содержащих член с одинаковой сигнатурой, то при реализации этого члена в
классе оба интерфейса будут использовать этот член для своей реализации.

Преимущества использования интерфейсов:
• Класс может реализовать несколько интерфейсов (допустимо
множественное наследование от интерфейсов).
• Если класс реализует интерфейс, она получает только имена и сигнатуры
метода.
• Интерфейсы определяют поведение экземпляров производных классов.
• Базовый класс может обладать не нужным функционалом, полученным от
других его базовых классов, чего можно избежать, применяя интерфейсы.

Модификатор interface

• Методы всегда public и abstract, даже если это не объявлено.
• Методы не могут быть final, strictfp, native, private, protected.
• Переменные только public static final, даже если это не объявлено.
• Переменные не могут быть strictfp, native, private, protected.
• Может только наследовать (extends) другой интерфейс, но не
реализовывать интерфейс или класс (implements).
 */

public class Main {
    @Test
    public void Test1Base() {

        SomeClass instance = new SomeClass();
        instance.method();
        instance.defaultMethod();
        //instance.staticMethod();
        System.out.println(instance.publicField);

        // UpCast
        SomeInterface instanceUp = instance;
        instanceUp.method();
        instanceUp.defaultMethod();
        SomeInterface.staticMethod();
        //instanceUp.staticMethod();
        // System.out.println(instanceUp.publicField); // Error

        // DownCast
        SomeClass instanceDown = (SomeClass) instanceUp;
        instanceDown.method();
        System.out.println(instanceDown.publicField);
    }

    @Test
    public void Test2MultiInterface() {

        SomeClassMultiInterface instance = new SomeClassMultiInterface();
        instance.method1();
        instance.method2();
        instance.method3();
        instance.defaultMethod();
        instance.defaultMethod2();

        // UpCast
        SomeInterface1 instanceUp1 = instance;
        instanceUp1.method1();
        instanceUp1.defaultMethod();
        instanceUp1.defaultMethod2();
        //instanceUp1.method2(); // Error
        //instanceUp1.method3(); // Error

        // UpCast
        SomeInterface2 instanceUp2 = instance;
        instanceUp2.method2();
        instanceUp2.defaultMethod();
        //instanceUp2.defaultMethod2();
        // instanceUp2.method1(); // Error
        // instanceUp2.method3(); // Error

        // UpCast
        SomeInterface3 instanceUp3 = instance;
        instanceUp3.method3();
        // instanceUp3.method1(); // Error
        // instanceUp3.method2(); // Error

        // DownCast
        SomeClassMultiInterface instanceDown = (SomeClassMultiInterface) instanceUp1;
        instanceDown.method1();
        instanceDown.method2();
        instanceDown.method3();
        instanceDown.defaultMethod();
        instanceDown.defaultMethod2();
    }

    @Test
    public void Test3Extends() {

        SomeExtendsClass instance = new SomeExtendsClass();
        instance.method1();
        instance.method2();
        instance.method3();
        instance.defaultMethod();


        ExtendsInterface1 instance1 = instance;
        instance1.method1();
        instance1.defaultMethod();

        ExtendsInterface2 instance2 = instance;
        instance2.method2();
        instance2.defaultMethod();

        ExtendsInterface3 instance3 = instance;
        instance3.method1();
        instance3.method2();
        instance3.method3();
        instance3.defaultMethod();
    }

    @Test
    public void Test4AbstractClass() {

        ConcreteClass instance = new ConcreteClass();
        instance.method();
    }


    @Test
    public void Test5AbstractClass() {

        DerivedClass instance = new DerivedClass();
        instance.method();

        InterfaceClassInheritance instance1 = instance;
        instance1.method();
    }
}
