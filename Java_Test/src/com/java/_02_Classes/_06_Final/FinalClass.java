package com.java._02_Classes._06_Final;

//При применении к классу, модификатор final запрещает другим классам
//наследоваться от этого класса.
public final class FinalClass {
    public int x;
    public int y;
}

// Попытка наследования от FinalClass приводит к ошибке компилятора.
class DerivedClass /*extends FinalClass*/ {   // Error
}
