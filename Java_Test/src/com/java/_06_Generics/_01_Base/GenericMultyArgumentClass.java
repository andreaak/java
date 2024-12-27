package com.java._06_Generics._01_Base;

public class GenericMultyArgumentClass<TYPE1, TYPE2> {
    // Поля
    public TYPE1 variable1;
    public TYPE2 variable2;

    // Конструктор.
    public GenericMultyArgumentClass(TYPE1 argument1, TYPE2 argument2) {
        this.variable1 = argument1;
        this.variable2 = argument2;
    }
}
