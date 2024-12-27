package com.java._04_Exceptions._02_UserExceptions;

import org.junit.Test;

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public void method() {
        System.out.println("Мое исключение!");
    }
}

class UserExceptionB extends UserException {
    public UserExceptionB(String message) {
        super(message);
    }
}

