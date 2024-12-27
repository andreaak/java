package com.java._06_Generics._03_Bound;

/**
 * Ограничения параметров типа
 */
class Base {
}

class Derived extends Base {
}

/**
 * T extends Base -  аргумент типа должен являться или быть производным от указанного базового класса.
 */
public class GenericClassBounded<T extends Base> {
}