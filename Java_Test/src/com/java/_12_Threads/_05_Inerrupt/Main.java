package com.java._12_Threads._05_Inerrupt;

import org.junit.Test;

public class Main {
    @Test
    public void TestDaemonThread1() {
//        Thread currentThread = currentThread();
//        currentThread.setPriority(Thread.MAX_PRIORITY);

        InterruptedThread th1 = new InterruptedThread("Did", 5);
        InterruptedThread th2 = new InterruptedThread("Did Not", 5);

        th1.setThread(th2);
        th2.setThread(th1);

        th1.setName("First Thread");
        th2.setName("Second Thread");

        th1.start();
        th2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(th1.getName() + " " + th1.isInterrupted());
        System.out.println(th2.getName() + " " + th2.isInterrupted());
    }
}