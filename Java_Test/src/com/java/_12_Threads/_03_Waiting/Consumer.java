package com.java._12_Threads._03_Waiting;

class Consumer extends Thread {
    Product p;
    int count;

    Consumer( Product p, int count ) {
        this.p = p;
        this.count = count;
    }

    // Получение товара
    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.getIdProduct();
        }
    }
}
