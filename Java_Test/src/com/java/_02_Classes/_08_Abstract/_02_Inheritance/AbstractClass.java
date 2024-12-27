package com.java._02_Classes._08_Abstract._02_Inheritance;

/**
 * Абстрактный класс может быть унаследован от абстрактного класса.
 * Реализация абстрактного метода из базового абстрактного класса, в производном абстрактном классе - не обязательна.
 */

/**
 * Абстрактный класс A.
 */
abstract class AbstractClassA {
    public abstract void operationA();
}

/**
 * Абстрактный класс B.
 */
abstract class AbstractClassB extends AbstractClassA {
    public abstract void operationB();
}

/**
 * Конкретный класс.
 */
class ConcreteClassA extends AbstractClassB {
    @Override
    public void operationA() {
        System.out.println("ConcreteClass.operationA");
    }

    @Override
    public void operationB() {
        System.out.println("ConcreteClass.operationB");
    }
}

