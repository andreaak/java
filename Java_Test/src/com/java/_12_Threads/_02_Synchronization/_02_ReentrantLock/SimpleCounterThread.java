package com.java._12_Threads._02_Synchronization._02_ReentrantLock;

class SimpleCounterThread extends Thread {
    private Counter counter;
    private int number;

    SimpleCounterThread( Counter counter, int number ) {
        this.counter = counter;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            counter.incrementCurrentValue();
        }
    }
}
