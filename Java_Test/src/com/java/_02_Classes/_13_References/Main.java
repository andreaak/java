package com.java._02_Classes._13_References;

import org.junit.Test;
import org.openjdk.jol.info.GraphLayout;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {

    @Test
    public void Test1() {
        Car obj = new Car(10, "Blue");

        SoftReference<Car> sr = new SoftReference<>(obj);
        WeakReference<Car> wr = new WeakReference<>(obj);

        ReferenceQueue<Car> rq = new ReferenceQueue<>();
        PhantomReference<Car> pr = new PhantomReference<>(obj, rq);

        System.out.println("Strong " + obj);
        System.out.println("Soft " + sr.get());
        System.out.println("Weak " + wr.get());
        System.out.println("Phantom " + pr.get());
        System.out.println("Queue " + rq.poll());

        obj = null;

        System.out.println("Strong " + obj);
        System.out.println("Soft " + sr.get());
        System.out.println("Weak " + wr.get());
        System.out.println("Phantom " + pr.get());
        System.out.println("Queue " + rq.poll());
        /*
        Strong com.java._02_Classes._13_References.Car@4eb7f003
        Soft com.java._02_Classes._13_References.Car@4eb7f003
        Weak com.java._02_Classes._13_References.Car@4eb7f003
        Phantom null
        Queue null

        Strong null
        Soft com.java._02_Classes._13_References.Car@4eb7f003
        Weak com.java._02_Classes._13_References.Car@4eb7f003
        Phantom null
        Queue null
         */
    }

    @Test
    public void Test2() {
        Car obj = new Car(10, "Blue");

        //SoftReference<Car> sr = new SoftReference<>(obj);
        WeakReference<Car> wr = new WeakReference<>(obj);

        ReferenceQueue<Car> rq = new ReferenceQueue<>();
        PhantomReference<Car> pr = new PhantomReference<>(obj, rq);

        System.out.println("Strong " + obj);
        //System.out.println("Soft " + sr.get());
        System.out.println("Weak " + wr.get());
        System.out.println("Phantom " + pr.get());
        System.out.println("Queue " + rq.poll());

        obj = null;
        System.gc();


        System.out.println("Strong " + obj);
        //System.out.println("Soft " + sr.get());
        System.out.println("Weak " + wr.get());
        System.out.println("Phantom " + pr.get());
        System.out.println("Queue " + rq.poll());
        /*
        Strong com.java._02_Classes._13_References.Car@3f102e87
        Weak com.java._02_Classes._13_References.Car@3f102e87
        Phantom null
        Queue null

        Strong null
        Finalize
        Weak null
        Phantom null
        Queue null
         */
    }

}


