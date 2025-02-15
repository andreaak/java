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

        GenericClassInterfaceBounded2<Interface2<Object>> my3 = new GenericClassInterfaceBounded2<>(new ClassImplementedInterfaces());
        GenericClassInterfaceBounded2<ClassImplementedInterfaces> my4 = new GenericClassInterfaceBounded2<>(new ClassImplementedInterfaces());
        System.out.println(my3.getGeneric());
        System.out.println(my4.getGeneric());

        GenericClassInterfaceBounded1<Interface1> my5 = new GenericClassInterfaceBounded1<>();
        GenericClassInterfaceBounded1<Interface3> my6 = new GenericClassInterfaceBounded1<>();
        //GenericClassInterfaceBounded1<Interface2<String>> my7 = new GenericClassInterfaceBounded1<>();
        /*
        4
        4
         */
    }

    @Test
    public void Test3MethodBounded() {
        Derived obj = GenericMethodBounded.testBounded(new Derived());
        //TestClass obj2 = testBounded(new TestClass()); //Error
    }
}
