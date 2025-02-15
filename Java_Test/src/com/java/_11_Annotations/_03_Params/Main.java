package com.java._11_Annotations._03_Params;

import org.junit.Test;

import java.lang.reflect.Method;

public class Main {
    @Test
    public void TestAnnotation1() {
        MathHandler mathHandler = new MathHandler();
        Class<?> cl = MathHandler.class;
        try {
            Method m = cl.getDeclaredMethod("addTwoNumbers", int.class, int.class);
            MathAnno mathAnno = m.getAnnotation(MathAnno.class);
            mathHandler.addTwoNumbers(mathAnno.num1(), mathAnno.num2());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestAnnotation2() {
        A a = new B();
        a.print();
        //A.print();
    }
}