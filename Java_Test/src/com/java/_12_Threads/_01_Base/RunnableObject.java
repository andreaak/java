package com.java._12_Threads._01_Base;

public class RunnableObject implements Runnable {
    // Для того, чтобы поток выполнялся параллельно
    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            try {
                Thread.sleep(2000);
                System.out.println("j = " + j + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
