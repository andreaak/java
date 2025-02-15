package com.java._12_Threads._04_Daemon;

class Daemon extends Thread {

    @Override
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Старт потока-демона");
                sleep(1000);
            } else {
                System.out.println("Старт обычного потока");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!isDaemon()) {
                System.out.println("Завершение работы обычного потока");
            } else {
                System.out.println("Завершение работы потока-демона");
            }
        }
    }
}
