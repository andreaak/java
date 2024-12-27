package com.java._02_Classes._09_Nested;

public class BaseClass {
    public void methodFromBase() {
        System.out.println("BaseClass.methodFromBase");
    }
}

class BaseClassOuter {
    public void methodFromBaseClassOuter() {
        System.out.println("BaseClassOuter.methodFromBase");
    }
}

