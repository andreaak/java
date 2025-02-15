package com.java._16_StreamAPI._01_Lambda;

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
        System.out.println("Выключатель ключен");

        for (IElectricityConsumer c : listeners) {
            c.electricityOn(this);
        }
    }
}
