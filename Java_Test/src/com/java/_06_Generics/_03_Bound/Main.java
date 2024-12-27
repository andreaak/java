package com.java._06_Generics._03_Bound;

import org.junit.Test;

public class Main {

    @Test
    public void Test1ClassBounded() {
        GenericClassBounded<Base> mc1 = new GenericClassBounded<>();

        GenericClassBounded<Derived> mc2 = new GenericClassBounded<>();

        //GenericClassBounded<String> mc3 = new GenericClassBounded<>(); // Ошибка.
    }

    @Test
    public void Test2InterfaceBounded() {
        GenericClassInterfaceBounded1<Interface1> my1 = new GenericClassInterfaceBounded1<>();
        GenericClassInterfaceBounded1<ClassImplementedInterfaces> my2 = new GenericClassInterfaceBounded1<>();

        GenericClassInterfaceBounded2<Interface2<Object>> my3 = new GenericClassInterfaceBounded2<>();
        GenericClassInterfaceBounded2<ClassImplementedInterfaces> my4 = new GenericClassInterfaceBounded2<>();
    }
}
