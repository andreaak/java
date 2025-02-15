package com.java._16_StreamAPI._01_Lambda.withoutLambdaExpression;

public class Lamp implements IElectricityConsumer {

    private void lightOn() {
        System.out.println("Лампа зажглась");
    }

    @Override
    public void electricityOn(Object sender) {
        lightOn();
    }
}
