package com.java._12_Threads._05_Inerrupt;

class InterruptedThread extends Thread {
    private int counter;
    private String word;
    private Thread thread;

    InterruptedThread( String word, int counter ) {
        this.word = word;
        this.counter = counter;
    }

    void setThread( Thread thread ) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            thread.interrupt();

            for (int i = 0; i < counter; i++) {
                System.out.println(word + i);
            }

            break;
        }
    }
}
