package com.java._02_Classes._09_Nested;

class _03_OuterClassLocal extends BaseClassOuter {
    private static int fieldStatic = 1;
    private int fieldInstance;

    public void methodLocalClass(int a) {

        /*public*/ class LocalClass{
            public void testLocal() {
                System.out.println("LocalClass.methodParameter - " + a);
                System.out.println("LocalClass.fieldInstance - " + fieldInstance);
                System.out.println("LocalClass.privateBaseClassOuterInstField - " + privateBaseClassOuterInstField);
            }
        }

        LocalClass lc = new LocalClass();
        lc.testLocal();
    }
}