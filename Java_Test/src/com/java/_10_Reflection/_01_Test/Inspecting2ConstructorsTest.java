package com.java._10_Reflection._01_Test;

import com.java._10_Reflection._01_Test.models.Bird;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class Inspecting2ConstructorsTest {
    /**
     * Метод getConstructors() - отримання всіх публічних конструкторів класу.
     */
    @Test
    public void givenClass_whenGetsAllConstructors_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Constructor<?>[] constructors = birdClass.getConstructors();

            assertEquals(3, constructors.length);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Отримуємо кожен конструктор для класу Bird,
     * передавши типи класів параметрів конструктора в оголошеному порядку.
     * Створюємо екземпляри об’єктів під час виконання, надаючи їхні параметри:
     */
    @Test
    public void givenClass_whenInstantiatesObjectsAtRuntime_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Constructor<?> cons1 = birdClass.getConstructor();
            Constructor<?> cons2 = birdClass.getConstructor(String.class);
            Constructor<?> cons3 = birdClass.getConstructor(String.class, boolean.class);

            Bird bird1 = (Bird) cons1.newInstance();
            Bird bird2 = (Bird) cons2.newInstance("Weaver bird");
            Bird bird3 = (Bird) cons3.newInstance("dove", true);

            assertEquals("bird", bird1.getName());
            assertEquals("Weaver bird", bird2.getName());
            assertEquals("dove", bird3.getName());

            assertFalse(bird1.isWalks());
            assertTrue(bird3.isWalks());
        } catch (Exception e) {
            fail();
        }
    }
}
