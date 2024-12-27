package com.java._04_Exceptions._01_Base;

import org.junit.Test;

public class Main {
    @Test
    public void Test1() {
        int a = 1, n = 2;

        try {
            // Попытка деления на ноль.
            a = a / (2 - n);
            System.out.println("a = " + a);
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Test2Throw() {
        Exception ex = new Exception("Мое исключение");

        try {
            throw ex;
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Test3Throw() {
        try {
            throw new Exception("Мое исключение");
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Test4Finally() {
        int a = 1, n = 2;

        try {
            System.out.println("Попытка деления на ноль.");
            System.out.println("a / (2 - n) = " + (a / (2 - n)));
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Блок finally.");
        }

        System.out.println("Конец кода.");
    }

    @Test
    public void Test5Finally() {
        try {
            System.out.println("Try");
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Catch");
        } catch (Error ex) {
            System.out.println("Error");
        }finally {
            System.out.println("Finaly");
        }
    }

    @Test
    public void Test6() {
        try {
            try {
                try {
                    throw new Exception("Exception");
                } catch (Exception e) {
                    System.out.println("Catch 1: " + e.getMessage());
                    throw new Exception();
                } finally {
                    System.out.println("Finally 1:");
                }
            } catch (Exception e) {
                System.out.println("Catch 2: " + e.getMessage());
                throw new Exception();
            } finally {
                System.out.println("Finally 2:");
                throw new Exception("New Exception");
            }
        } catch (Exception e) {
            System.out.println("Catch 3: " + e.getMessage());
        } finally {
            System.out.println("Finally 3:");
        }
    }
    @Test
    public void Test7NullPointerException() {
        try {
            throw null;
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}