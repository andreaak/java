package com.java._12_Threads._04_Daemon;

import org.junit.Test;

public class Main {
    @Test
    public void TestDaemonThread1() {
        Daemon daemon1 = new Daemon();
        Daemon daemon2 = new Daemon();

        daemon1.setDaemon(true);

        daemon1.start();
        daemon2.start();

        /*
        Старт потока-демона
        Старт обычного потока
        */
    }
}

