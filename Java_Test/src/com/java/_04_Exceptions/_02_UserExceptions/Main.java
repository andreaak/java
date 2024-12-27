package com.java._04_Exceptions._02_UserExceptions;

import org.junit.Test;

public class Main {
    @Test
    public void Test1() {
        try {
            throw new UserException("TestException");
        } catch (UserException e) {
            System.out.println("Обработка исключения.");
            e.method();
        }
    }

    @Test
    public void Test2Finally() {
        try {
            throw new UserException("TestException");
        } catch (UserException userException) {
            System.out.println("Обработка исключения 1:");
            userException.method();

            try {
                throw userException;
            } catch (UserException exception) {
                System.out.println("Обработка исключения 2:");
                exception.method();
            }
        } finally {
            System.out.println("Блок finally.");
        }

        System.out.println("Конец кода.");;
    }

    @Test
    public void Test3Order() {
        try {
            //throw new UserExceptionB("MyExceptionB");
            throw new UserException("MyExceptionA");
            //throw new Exception("Exception");
        } catch (UserExceptionB e) {
            System.out.println(e.getMessage());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
