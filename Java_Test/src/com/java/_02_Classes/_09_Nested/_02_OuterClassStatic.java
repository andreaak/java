package com.java._02_Classes._09_Nested;

class _02_OuterClassStatic extends BaseClassOuter {
    private static int fieldStatic = 1;
    private int fieldInstance;

    public void methodOuter() {
        fieldStatic = 4;
        fieldInstance = 5;
        System.out.println("_02_OuterClassStatic.methodOuter");
    }

    public static void methodOuterStatic() {
        fieldStatic = 6;
        //fieldInstance = 3;
        System.out.println("_02_OuterClassStatic.methodOuterStatic");
    }

    public static class NestedStatic extends BaseClassNested {
        //Не содержит ссылку на внешний класс

        int i;
        static int st;

        public static void staticMethodFromNested() {
            fieldStatic = 2;
            //fieldInstance = 3;

            //methodOuter();
            methodOuterStatic();

            //i =5;
            st = 6;

            System.out.println("NestedStatic.staticMethodFromNested");
        }

        public void methodNested() {
            fieldStatic = 2;
            //fieldInstance = 3;

            //methodOuter();
            methodOuterStatic();

            i =5;
            st = 6;
            int sss = this.i;
        }
    }
}