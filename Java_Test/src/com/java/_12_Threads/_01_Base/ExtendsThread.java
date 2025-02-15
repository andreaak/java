package com.java._12_Threads._01_Base;

public class ExtendsThread extends Thread {
    // Для того, чтобы поток выполнялся параллельно
    public void run() {
        for (int j = 0; j < 10; j++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            try {
                Thread.sleep(2000);
                System.out.println("j = " + j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
