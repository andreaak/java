package com.java._12_Threads._02_Synchronization._01_Base;

import org.junit.Test;

import java.io.IOException;

public class Main {
    @Test
    public void TestThread1() throws IOException {
        Ticket[] t = {
                new Ticket(10),
                new Ticket(20),
                new Ticket(30),
                new Ticket(40)
        };

        Cashier c1 = new Cashier(1, t);
        Cashier c2 = new Cashier(2, t);
        Cashier c3 = new Cashier(3, t);
        Cashier c4 = new Cashier(4, t);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*
        Cashier 1 ticket 10 try
        Cashier 1 ticket 10
        Cashier 1 ticket 20 try
        Cashier 4 ticket 10 try
        Cashier 3 ticket 10 try
        Cashier 2 ticket 10 try
        Cashier 1 ticket 20
        Cashier 1 ticket 30 try
        Cashier 2 ticket 20 try
        Cashier 3 ticket 20 try
        Cashier 4 ticket 20 try
        Cashier 1 ticket 30
        Cashier 1 ticket 40 try
        Cashier 4 ticket 30 try
        Cashier 3 ticket 30 try
        Cashier 2 ticket 30 try
        Cashier 1 ticket 40
        Cashier 2 ticket 40 try
        Cashier 3 ticket 40 try
        Cashier 4 ticket 40 try`
         */
    }
}
