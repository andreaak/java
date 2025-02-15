package com.java._12_Threads._03_Waiting;

import org.junit.Test;

public class Main {
    @Test
    public void TestThreadWait1() {
        Product p = new Product();
        Producer pr = new Producer(p, 5);
        Consumer cons = new Consumer(p, 5);

        pr.start();
        cons.start();

        /*
        Set 1
        Get 1
        Set 2
        Get 2
        Set 3
        Get 3
        Set 4
        Get 4
         */
    }

    @Test
    public void TestThreadWait2() {
        Product2 p = new Product2();
        Producer pr = new Producer(p, 5);
        Consumer cons = new Consumer(p, 5);

        pr.start();
        cons.start();
        /*
        Set 1
        Set 2
        Get 2
        Get 2
        Get 2
        Get 2
        Get 2
        Set 3
        Set 4
        Set 5
         */
    }
}

