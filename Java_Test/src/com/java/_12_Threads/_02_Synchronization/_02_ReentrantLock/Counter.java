package com.java._12_Threads._02_Synchronization._02_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private long counter = 0;
    private Lock reentrantLock = new ReentrantLock();

    public void incrementCurrentValue() {
        reentrantLock.lock();
        try {
            counter++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public long getCounter() {
        return counter;
    }
}
