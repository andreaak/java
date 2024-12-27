package com.java._02_Classes._10_Anonymous;

import org.junit.Test;

/**
 Анонимный класс (anonymous class) – внутренний класс без имени.
 Анонимные классы используются если необходимо новую
 абстракцию, с которой удобно работать в пределах метода и она не
 нужна за его пределами.

 Основное ограничение при использовании анонимных классов – это
 невозможность описания конструктора, так как класс не имеет
 имени. Аргументы, указанные в скобках, автоматически
 используются для вызова конструктора базового класса с теми же
 параметрами.

 Ограничения у анонимных классов такие же как и у локальных классов:
 • они видны только в пределах блока, в котором объявлены;
 • они не могут быть объявлены как private, public, protected или static;
 • они не могут иметь внутри себя статических объявлений (полей, методов, классов),
 исключением являются константы (static final).

 Использование анонимных классов оправдано во многих случаях:
 • тело класса является очень коротким;
 • нужен только один экземпляр класса;
 • класс используется в месте его создания или сразу после него;
 • имя класса не важно и не облегчает понимание кода.
 */

public class Main {

    @Test
    public void Test1WithInterface() {
        // Локальные переменные доступны в блоке объявления анонимного класса
        int n = 100;

        // Объявление анонимного (внутреннего) класса
        Interface instance = new Interface() {
            public double d = 1.3;
            protected String str = "Anonymous class";
            private int num = 10;

            @Override
            public void method() {
                num = 1234;
                num = n;
                //n = 345;Error
                System.out.println("instance1: d = " + d + ", str = " + str + ", num = " + num);
            }

            public int getValue() {
                return 1;
            }

            public int getPublicField() {
                return 2;
            }
        };

        // Вызов метода объекта анонимного класса
        instance.method();
        instance.getValue();
        // Метод не доступен
        // System.out.println(instance.getPublicField());

        /*
        instance1: d = 1.3, str = Anonymous class, num = 100
         */
    }

    @Test
    public void Test2WithClass() {

        // Объявление анонимного (внутреннего) класса
        ConcreteClass instance1 = new ConcreteClass() {
            @Override
            public void method() {
                System.out.println("instance1: method()");
            }
        };

        // Объявление анонимного (внутреннего) класса
        Interface instance2 = new ConcreteClass() {
            int protectedField = 3;

            @Override
            public void method() {
                System.out.println("instance2: method()");
            }

            @Override
            public int getValue() {
                return this.protectedField;
            }
        };

        instance1.method();
        instance2.method();

        System.out.println("instance1: publicField = " + instance1.getValue() + "    instance2: publicField = " + instance2.getValue());

        /*
        instance1: method()
        instance2: method()
        instance1: publicField = 10    instance2: publicField = 3
         */
    }

    @Test
    public void Test3AAnonymousClassWithCtor() {

        // Объявление анонимного (внутреннего) класса
        var instance = new AnonymousClassWithCtor(5) {
            public double d = 1.3;
            protected String str = "Anonymous class";
            private int num = 10;

            public int getPublicField() {
                return 2;
            }
        };

        // Метод не доступен
        System.out.println(instance.d);
        System.out.println(instance.i);
        System.out.println(instance.str);
        System.out.println(instance.getPublicField());

        /*
        1.3
        5
        Anonymous class
        2
         */
    }
}


