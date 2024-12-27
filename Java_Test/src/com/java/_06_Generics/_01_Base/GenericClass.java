package com.java._06_Generics._01_Base;

/**
 * Универсальные шаблоны.
 * На 8-й строке создаем класс с именем MyClass, параметризированный указателем места заполнения типом - T
 */
public class GenericClass<T> {
    public T field;

    public void method() {
        System.out.println(field.getClass());
    }
}



