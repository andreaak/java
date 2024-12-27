package com.java._05_Enums;

public enum CompanyCtorAndMethods {
    // Экземпляры.
    ITVDN(1000), GOOGLE(100), SKYNET(10); //, TEST, TEST2(1000, "string"); // - Error
    int value;

    // Конструктор может быть только private.
    CompanyCtorAndMethods(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}