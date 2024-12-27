package com.java._02_Classes._08_Abstract._01_Base;

class ConcreteClassBase {
    public void operation() {
        System.out.println("ConcreteClassBase.operation");
    }
}

/**
 * Абстрактный класс.
 */
public abstract class AbstractClass extends ConcreteClassBase {
    // 1.
    // ћетод передаетс¤ производному классу как при наследовании от конкретного класса.
    public void simpleMethod() {
        System.out.println("AbstractClass.simpleMethod");
    }

    // 2.
    // ћетод передаетс¤ производному классу как при наследовании от конкретного класса.
    // ѕерегружен в производном классе
    public void overriddenMethod() {
        System.out.println("AbstractClass.overriddenMethod");
    }

    // 3.
    // јбстрактный метод - реализуетс¤ в производном классе.
    abstract public void abstractMethod();
}

/**
 * Конкретный класс.
 */
class ConcreteClass extends AbstractClass {
    // ѕереопредел¤ем метод overriddenMethod() базового абстрактного класса.
    // ≈сли мы не переопределим метод, то будет использован метод из базового класса.

    @Override
    public void overriddenMethod() {
        System.out.println("ConcreteClass.overriddenMethod");
    }

    // –еализуем абстрактный метод abstractMethod() базового абстрактного класса.
    @Override
    public void abstractMethod() {
        System.out.println("ConcreteClass.abstractMethod");
    }
}
