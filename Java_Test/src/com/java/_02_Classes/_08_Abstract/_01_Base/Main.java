package com.java._02_Classes._08_Abstract._01_Base;


import org.junit.Test;

/*
Абстракция в ООП – это придание объекту характеристик, которые
отличают его от всех других объектов, четко определяя его
концептуальные границы.

Абстрагирование в ООП – это способ выделить набор значимых
характеристик объекта, исключая из рассмотрения незначимые.
Соответственно, абстракция – это набор всех таких характеристик.

Абстрактный класс в объектно-ориентированном программировании – это базовый
класс, который не предполагает создания экземпляров через вызов конструктора
напрямую, но экземпляр абстрактного класса создается неявно при построении
экземпляра производного конкретного класса.

Ключевое слово abstract может использоваться с классами и методами.

Возможности и ограничения абстрактных классов:
• Экземпляр абстрактного класса создать нельзя через вызов
конструктора напрямую, но экземпляр абстрактного класса создается
неявно при построении экземпляра производного конкретного класса.
• Абстрактные классы могут содержать как абстрактные, так и не
абстрактные члены.
• Не абстрактный (конкретный) класс, являющийся производным от
абстрактного, должен содержать фактические реализации всех
наследуемых абстрактных членов либо класс должен быть объявлен как
abstract.

Возможности абстрактных методов:
•Абстрактный метод является неявным методом.
•Создание абстрактных методов допускается только в абстрактных
классах.
•Тело абстрактного метода отсутствует; создание метода просто
заканчивается точкой с запятой, после сигнатуры ставить фигурные
скобки { } не нужно.
•Реализация предоставляется методом переопределения override,
который является членом неабстрактного класса.

Модификатор abstract

1. Применяется только для методов и классов.
2. У абстрактных методов нет тела метода.
3. Является противоположностью final: final класс не может наследоваться, abstract класс
обязан наследоваться.

Класс должен быть объявлен как abstract если:
• он содержит хотя бы один абстрактный метод;
• он не предоставляет реализацию наследуемых абстрактных методов;
• он не предоставляет реализацию методов интерфейса, реализацию которого он объявил;
• необходимо запретить создание экземпляров класса.
 */

public class Main {
    @Test
    public void Test1() {

        AbstractClass instance = new ConcreteClass();
        instance.operation();
        instance.simpleMethod();
        instance.overriddenMethod();
        instance.abstractMethod();

        /*
        ConcreteClassBase.operation
        AbstractClass.simpleMethod
        ConcreteClass.overriddenMethod
        ConcreteClass.abstractMethod
        */
    }
}