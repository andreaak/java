package com.java._05_Enums;

public enum CompanyAbstractMethod {
    // Экземпляры.
    ITVDN(1000) {
        // Можно переопределять методы для отдельных экземпляров.
        @Override
        public int getValue() {
            return 10 + this.value;
        }

        // Абстрактные методы обязятельно должны быть переопределены в экземплярах перечисляемых типов.
        @Override
        public String getCurrency() {
            return "dollars";
        }
    }, GOOGLE(100) {
        // Абстрактные методы обязятельно должны быть переопределены в экземплярах перечисляемых типов.
        @Override
        public String getCurrency() {
            return "cents";
        }
    }, SKYNET(10) {
        // Можно переопределять методы для отдельных экземпляров.
        @Override
        public String toString() {
            return "CompanyAbstractMethod: " + super.toString();
        }

        // Абстрактные методы обязятельно должны быть переопределены в экземплярах перечисляемых типов.
        @Override
        public String getCurrency() {
            return "euros";
        }
    }; //, TEST, TEST2(1000, "string"); // - Error
    int value;

    // Конструктор может быть только private.
    CompanyAbstractMethod(int value) {
        this.value = value;
    }

    CompanyAbstractMethod(int value, int i) {
        this.value = value;
    }

    // Можно переопределять методы "для всех" экземпляров перечисляемого типа.
    @Override
    public String toString() {
        return "CompanyAbstractMethod: " + super.toString() + ", salary = " + getValue() + " " + getCurrency();
    }

    public int getValue() {
        return value;
    }

    public abstract String getCurrency();
}