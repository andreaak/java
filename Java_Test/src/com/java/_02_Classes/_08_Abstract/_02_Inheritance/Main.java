package com.java._02_Classes._08_Abstract._02_Inheritance;


import org.junit.Test;

public class Main {
    @Test
    public void Test1() {

        AbstractClassA instance = new ConcreteClassA();
        instance.operationA();
        //instance.operationB();

        AbstractClassB instance2 = new ConcreteClassA();
        instance2.operationA();
        instance2.operationB();
    }
}