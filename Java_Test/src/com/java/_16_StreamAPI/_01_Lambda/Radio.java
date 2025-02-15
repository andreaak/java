package com.java._16_StreamAPI._01_Lambda;

public class Radio implements IElectricityConsumer {

    private void playMusic() {
        System.out.println("Radio plays");
    }

    public void electricityOn(Object sender) {
        playMusic();
    }
}
