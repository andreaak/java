package com.java._02_Classes._12_Cloning._01_Deep;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;

public class Main {

    @Test
    public void TestCloning1Constructor() {
        Cow originalCow = new Cow("Milka", 5, 1);;
        Cow cloneCow = new Cow(originalCow);

        System.out.println(originalCow);
        System.out.println(cloneCow);

        /*
        Cow{name='Milka', weight=5, age=1}
        Cow{name='Milka', weight=5, age=1}
         */
    }

    @Test
    public void TestCloning2Reflection() {
        Cow originalCow = new Cow("Milka", 5, 1);
        System.out.println("Original cow = " + originalCow);

        Cow copiedCow = originalCow;

        try {
            Field name = Cow.class.getDeclaredField("name");
            Field weight = Cow.class.getDeclaredField("weight");

            name.setAccessible(true);
            weight.setAccessible(true);

            name.set(copiedCow, "Byrenka");
            weight.set(copiedCow, 2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(copiedCow);

        /*
        Original cow = Cow{name='Milka', weight=5, age=1}
        Cow{name='Byrenka', weight=2, age=1}
         */
    }

    @Test
    public void TestCloning3Serialization() {
        Cow burenka = new Cow("Byrenka", 200, 5);

        ByteArrayOutputStream byteOutput = null;
        ByteArrayInputStream byteInput = null;

        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try {
            byteOutput = new ByteArrayOutputStream();
            output = new ObjectOutputStream(byteOutput);
            output.writeObject(burenka);

            byteInput = new ByteArrayInputStream(byteOutput.toByteArray());
            input = new ObjectInputStream(byteInput);

            Cow cloneBurenka = (Cow) input.readObject();
            System.out.println(burenka);
            System.out.println(cloneBurenka);

            cloneBurenka.setWeight(500);

            System.out.println(burenka);
            System.out.println(cloneBurenka);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (byteOutput != null) {
                try {
                    byteOutput.flush();
                    byteOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteInput != null) {
                try {
                    byteInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(output != null) {
                try {
                    output.flush();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
        Cow{name='Byrenka', weight=200, age=5}
        Cow{name='Byrenka', weight=200, age=5}
        Cow{name='Byrenka', weight=200, age=5}
        Cow{name='Byrenka', weight=500, age=5}
         */
    }

    @Test
    public void TestCloning4StaticMethod() {
        // 1st example
        Cow cloneCow = Cow.getCowInstance("Robert", 20, 10);

        System.out.println(cloneCow);

        // 2nd example
        Cow cow = new Cow("Robert", 20, 10);
        System.out.println("Original Cow = " + cow);

        Cow copiedcow = Cow.getCowInstance(cow);
        System.out.println("Copied Cow = " + copiedcow);
    }
}


