package com.java._04_Exceptions._04_InnerExceptions;

import org.junit.Test;

public class Main {
    @Test
    public void Test1() {
        ClassWithException instance = new ClassWithException();
        //instance.catchInner(); // Попробовать вызвать.
        try {
            instance.catchInner();
        } catch (Exception exception) {
            System.out.println("Exception caught: " + exception.getMessage());
            System.out.println("Cause Exception:  " + exception.getCause());
        }

        /*
        Exception caught: Это внешнее исключение!
        Cause Exception:  java.lang.Exception: Это внутреннее исключение!
         */
    }
}
