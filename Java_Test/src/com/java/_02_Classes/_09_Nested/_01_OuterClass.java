package com.java._02_Classes._09_Nested;

class _01_OuterClass extends BaseClassOuter {
    private static int fieldStatic = 1;
    private int fieldInstance;

    public void methodOuter() {
        fieldStatic = 4;
        fieldInstance = 5;
        System.out.println("_01_OuterClass.methodOuter");
    }

    public static void methodOuterStatic() {
        fieldStatic = 6;
        //fieldInstance = 3;
        System.out.println("_01_OuterClass.methodOuterStatic");
    }

    public class Nested extends BaseClassNested {
        _01_OuterClass instance = new _01_OuterClass();

        int i;
        static int st;

        public void methodNested() {
            fieldStatic = 2;
            fieldInstance = 3;


            instance.fieldStatic = 2;
            instance.fieldInstance = 3;

            methodOuter();
            methodOuterStatic();

            i =5;
            st = 6;
            int sss = this.i;

            System.out.println("Nested.methodNested");
        }

        public static void methodStaticNested() {
            fieldStatic = 2;
            //fieldInstance = 3;

            //instance.fieldStatic = 2;
            //instance.fieldInstance = 3;

            //methodOuter();
            methodOuterStatic();

            //i =5;
            st = 6;
        }
    }
}