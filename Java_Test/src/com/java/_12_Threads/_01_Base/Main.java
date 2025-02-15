package com.java._12_Threads._01_Base;

import org.junit.Test;

public class Main {
    @Test
    public void TestThread1InterfaceRunnable() throws InterruptedException {
        // Экземпляр класса OtherThread передается в конструктор объекта класса Thread
        Thread other = new Thread(new RunnableObject());

        other.start();

        for (int i = 0; i < 5; i++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            Thread.sleep(2000);
            System.out.println("i = " + i);
            if (i == 2) {
                // Метод join(), останавливает поток, в котором выполняется метод join()
                // И будет заблокирован(поток main), пока не закончится поток Other
                System.out.println(Thread.currentThread().getName());
                other.join();
            }
        }

        /*
        i = 0
        j = 0 Thread-0
        i = 1
        j = 1 Thread-0
        i = 2
        main
        j = 2 Thread-0
        j = 3 Thread-0
        j = 4 Thread-0
        i = 3
        i = 4
         */
    }

    @Test
    public void TestThread2ExtendThread() throws InterruptedException {
        // Какой поток выполнится первым - не известно
        new ExtendsThread().start();

        for (int i = 0; i < 10; i++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            Thread.sleep(2000);
            System.out.println("i = " + i);
        }
    }

    @Test
    public void TestThread3Info() throws InterruptedException {
        // Статический метод currentThread() инкапсулирует текущий поток в этот объект
        Thread myThread = Thread.currentThread();
        // Узнаем имя потока
        System.out.println("Name of Thread: " + myThread.getName());
        // Изменяем имя потока
        myThread.setName("MyThread");
        System.out.println("Thread name: " + myThread.getName());
        // Узнаем приоритет потока, по умолчанию 5 у main
        System.out.println("Priority: " + myThread.getPriority());
        // Изменяем приоритет потока от 1...10
        myThread.setPriority(10);
        System.out.println("Priority: " + myThread.getPriority());
        // Проверяем, жив ли поток
        System.out.println("Is Thread Alive?: " + myThread.isAlive());
    }
}

