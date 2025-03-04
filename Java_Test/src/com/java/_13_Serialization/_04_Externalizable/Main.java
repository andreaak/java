package com.java._13_Serialization._04_Externalizable;

import org.junit.Test;

import java.io.*;

public class Main {
    @Test
    public void TestExternalizable1() {
        Student student = new Student(1, "Yevhenii");
        System.out.println(student);

        File f = new File("files\\external.txt");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f))) {
            outputStream.writeObject(student);
            student = (Student) inputStream.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        Student Constructor
        Student{id=1, username='Yevhenii'}

        Student default Constructor
        Student{id=1, username='Yevhenii'}
         */
    }
}
