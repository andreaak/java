package com.java._12_Threads._02_Synchronization._01_Base;

public class Cashier extends Thread {
    int id;
    Ticket[] t;

    Cashier(int id, Ticket[] t) {
        this.id = id;
        this.t = t;
    }

    // synchronized указывает на то, что все что происходит в методе run делается как единное целое
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            // Кассир просматривает массив билетов, если какой-то билет не куплен, меняет флаг на true
//            if (!t[i].isBought) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e);
//                }
//                t[i].isBought = true;
//                System.out.println("Cashier " + id + " ticket " + t[i].place);
//            }
            t[i].buy(this);
        }
    }
}
