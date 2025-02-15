package com.java._10_Reflection._01_Test;

import com.java._10_Reflection._01_Test.models.Dog;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Inspecting1JavaClassesTest {
    /**
     * Отримання імені об'єкта з класу Class.
     * Метод getSimpleName класу повертає основне ім’я класу об’єкта, як воно було б у його декларації.
     * Інші два методи повертають повне ім’я класу, включаючи оголошення пакета.
     */
    @Test
    public void givenObject_whenGetsClassName_thenCorrect() {
        Object dog = new Dog("dog");
        Class<?> clazz = dog.getClass();

        assertEquals("Dog", clazz.getSimpleName());
        assertEquals("com.java._10_Reflection._01_Test.models.Dog", clazz.getName());
        assertEquals("com.java._10_Reflection._01_Test.models.Dog", clazz.getCanonicalName());
    }

    /**
     * Створюємо об’єкт класу Dog, якщо ми знаємо його повне ім’я класу
     */
    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() {
        try {
            Class<?> clazz = Class.forName("com.java._10_Reflection._01_Test.models.Dog");
            Constructor<?> constructor = clazz.getConstructor(String.class);
            Object object = constructor.newInstance("Bobik");
            Dog instance = (Dog) object;

            assertEquals("Bobik", instance.getName());
            assertEquals("bones", instance.eat());
            //assertEquals("woff", instance.getSound());
            assertEquals("walks", instance.move());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Клас java.lang.reflect.Modifier надає статичні методи,
     * які аналізують повернуте ціле число на наявність або відсутність певного модифікатора.
     */
    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() {
        try {
            Class<?> dogClass = Class.forName("com.java._10_Reflection._01_Test.models.Dog");
            Class<?> animalClass = Class.forName("com.java._10_Reflection._01_Test.models.Animal");

            int dogMods = dogClass.getModifiers();
            int animalMods = animalClass.getModifiers();

            assertTrue(Modifier.isPublic(dogMods));
            assertTrue(Modifier.isAbstract(animalMods));
            assertTrue(Modifier.isPublic(animalMods));
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Клас Package, надає інформацію про пакет.
     * Викликається методом getPackage об’єкта класу.
     */
    @Test
    public void givenClass_whenGetsPackageInfo_thenCorrect() {
        Dog dog = new Dog("dog");
        Class<?> dogClass = dog.getClass();
        Package pkg = dogClass.getPackage();

        assertEquals("com.java._10_Reflection._01_Test.models", pkg.getName());
    }

    /**
     * У багатьох випадках, особливо під час використання бібліотечних класів
     * або вбудованих класів Java, ми можемо не знати наперед
     * суперклас об’єкта, який ми використовуємо.
     */
    @Test
    public void givenClass_whenGetsSuperClass_thenCorrect() {
        Dog dog = new Dog("dog");
        String str = "any string";

        Class<?> dogClass = dog.getClass();
        Class<?> dogSuperClass = dogClass.getSuperclass();

        assertEquals("Animal", dogSuperClass.getSimpleName());
        assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
    }

    /**
     * Отримання списку інтерфейсів, реалізованих даним класом.
     */
    @Test
    public void givenClass_whenGetsImplementedInterfaces_thenCorrect() {
        try {
            Class<?> dogClass = Class.forName("com.java._10_Reflection._01_Test.models.Dog");
            Class<?> animalClass = Class.forName("com.java._10_Reflection._01_Test.models.Animal");

            Class<?>[] dogInterfaces = dogClass.getInterfaces();
            Class<?>[] animalInterfaces = animalClass.getInterfaces();

            assertEquals(1, dogInterfaces.length);
            assertEquals(1, animalInterfaces.length);
            assertEquals("Moving", dogInterfaces[0].getSimpleName());
            assertEquals("Eating", animalInterfaces[0].getSimpleName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Отримання конструкторів класу.
     */
    @Test
    public void givenClass_whenGetsConstructor_thenCorrect() {
        try {
            Class<?> dogClass = Class.forName("com.java._10_Reflection._01_Test.models.Dog");

            Constructor<?>[] constructors = dogClass.getConstructors();

            assertEquals(1, constructors.length);
            assertEquals("com.java._10_Reflection._01_Test.models.Dog", constructors[0].getName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Отримання полів класу.
     */
    @Test
    public void givenClass_whenGetsFields_thenCorrect() {
        try {
            Class<?> animalClass = Class.forName("com.java._10_Reflection._01_Test.models.Animal");
            Field[] fields = animalClass.getDeclaredFields();

            List<String> actualFields = new ArrayList<>();
            for (Field field : fields) {
                actualFields.add(field.getName());
            }

            assertEquals(2, actualFields.size());
            assertTrue(actualFields.containsAll(Arrays.asList("name", "CATEGORY")));
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Отримання методів класу.
     */
    @Test
    public void givenClass_whenGetsMethods_thenCorrect() {
        try {
            Class<?> animalClass = Class.forName("com.java._10_Reflection._01_Test.models.Animal");
            Method[] methods = animalClass.getDeclaredMethods();

            List<String> actualMethods = new ArrayList<>();
            for (Method method : methods) {
                actualMethods.add(method.getName());
            }

            assertEquals(3, actualMethods.size());
            assertTrue(actualMethods.containsAll(Arrays.asList("getName", "setName", "getSound")));
        } catch (Exception e) {
            fail();
        }
    }
}
