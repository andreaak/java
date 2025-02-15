package com.java._12_Threads._02_Synchronization._02_ReentrantLock;

import org.junit.Test;

public class Main {
    @Test
    public void TestReentrantLock1() {
        Counter counter = new Counter();
        SimpleCounterThread[] counterThread = new SimpleCounterThread[100];

        fillingArrayOfCounterThread(counter, counterThread);
        startingEachThread(counterThread);
        joinEveryThread(counterThread);

        System.out.println(counter.getCounter());

        /*
        100000
         */
    }

    private static void joinEveryThread(SimpleCounterThread[] counterThread) {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            try {
                simpleCounterThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startingEachThread(SimpleCounterThread[] counterThread) {
        for (SimpleCounterThread simpleCounterThread : counterThread) {
            simpleCounterThread.start();
        }
    }

    private static void fillingArrayOfCounterThread(Counter counter, SimpleCounterThread[] counterThread) {
        for (int i = 0; i < 100; i++) {
            counterThread[i] = new SimpleCounterThread(counter, 1000);
        }
    }
}


