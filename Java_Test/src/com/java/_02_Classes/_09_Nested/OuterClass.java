package com.java._02_Classes._09_Nested;

class OuterClass extends BaseClassOuter {
    private static int fieldStatic = 1;
    private int fieldInstance;

    public void methodOuter() {
        fieldStatic = 4;
        fieldInstance = 5;
        System.out.println("OuterClass.methodOuter");
    }

    public static void methodOuterStatic() {
        fieldStatic = 6;
        //fieldInstance = 3;
        System.out.println("OuterClass.methodOuterStatic");
    }

    public class Nested extends BaseClass {
        OuterClass instance = new OuterClass();

        public void methodNested() {
            fieldStatic = 2;
            fieldInstance = 3;

            instance.fieldStatic = 2;
            instance.fieldInstance = 3;

            methodOuter();
            methodOuterStatic();

            System.out.println("Nested.method");
        }
    }

    public static class NestedStatic {
        public static void staticMethodFromNested() {
            fieldStatic = 2;
            //fieldInstance = 3;

            //methodOuter();
            methodOuterStatic();

            System.out.println("NestedStatic.staticMethodFromNested");
        }
    }
}