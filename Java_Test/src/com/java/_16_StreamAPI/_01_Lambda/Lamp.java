package com.java._16_StreamAPI._01_Lambda;

public class Lamp implements IElectricityConsumer {

    private void lightOn() {
        System.out.println("Лампа зажглась");
    }

    public void electricityOn(Object sender) {
        lightOn();
    }
}
