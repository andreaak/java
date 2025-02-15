package com.java._16_StreamAPI._01_Lambda;

// Функциональный интерфейс( с 1 методом )
// Аннотация контролиует, что интерфейс является функциональным
// должен иметь один абстрактный метод но множество дефолтных и статических методов
@FunctionalInterface
public interface IElectricityConsumer {

    void electricityOn(Object sender);
    //void electricityOn2(Object sender); Error second method
}
