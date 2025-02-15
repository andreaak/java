package com.java._16_StreamAPI._01_Lambda.withoutLambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class Switcher {
    private List<IElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener( IElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener( IElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включен");
//        if (consumer != null)
//            consumer.electricityOn();
        for (IElectricityConsumer c : listeners) {
            c.electricityOn(this); // this, вызывает объект самого себя, в зависимости от того, кто обращается к switchOn
        }
    }
}
