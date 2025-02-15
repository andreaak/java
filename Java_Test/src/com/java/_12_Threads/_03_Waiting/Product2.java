package com.java._12_Threads._03_Waiting;

class Product2 extends Product{

    synchronized void getIdProduct() {

        System.out.println("Get " + this.id);
    }

    synchronized void setIdProduct( int id ) {
        this.id = id;
        System.out.println("Set " + this.id);
    }
}
