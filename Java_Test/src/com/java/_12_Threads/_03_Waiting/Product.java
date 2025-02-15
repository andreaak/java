package com.java._12_Threads._03_Waiting;

class Product {
    int id;
    boolean isProduced;

    synchronized void getIdProduct() {
        // Если товар не произведен, потребитель засыпает
        if (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Get " + this.id);
        isProduced = false;
        // Метод notify() выводит из блокировки другой поток, который находился в методе wait()
        notify();
    }

    synchronized void setIdProduct( int id ) {
        // Если товар произведен, тогда засыпаем
        if (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.id = id;
        System.out.println("Set " + this.id);
        isProduced = true;
        notify();
    }
}
