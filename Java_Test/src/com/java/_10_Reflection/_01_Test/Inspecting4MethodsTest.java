package com.java._10_Reflection._01_Test;

import com.java._10_Reflection._01_Test.models.Bird;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Inspecting4MethodsTest {
    /**
     * Метод getMethods() повертає масив усіх публічних методів класу та суперкласів.
     */
    @Test
    public void givenClass_whenGetsAllPublicMethods_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Method[] methods = birdClass.getMethods();
            List<String> methodNames = new ArrayList<>();
            for (Method method : methods) {
                methodNames.add(method.getName());
            }

            assertTrue(methodNames.containsAll(Arrays
                    .asList("equals", "notifyAll", "hashCode",
                            "isWalks", "eat", "toString")));
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Метод getDeclaredMethods() повертає усі методи класу.
     */
    @Test
    public void givenClass_whenGetsOnlyDeclaredMethods_thenCorrect(){
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Method[] methods = birdClass.getDeclaredMethods();

            List<String> actualMethodNames = new ArrayList<>();
            for (Method method : methods) {
                actualMethodNames.add(method.getName());
            }

            List<String> expectedMethodNames = Arrays
                    .asList("setWalks", "isWalks", "getSound", "eat", "getPrivate");

            assertEquals(expectedMethodNames.size(), actualMethodNames.size());
            assertTrue(expectedMethodNames.containsAll(actualMethodNames));
            assertTrue(actualMethodNames.containsAll(expectedMethodNames));
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Спочатку викликаємо метод walks() і перетворюємо тип повернення до відповідного типу даних,
     * а потім перевіряємо його значення. Пізніше ми викликаємо метод setWalks(),
     * щоб змінити це значення та перевірити знову.
     */
    @Test
    public void givenMethod_whenInvokes_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Bird bird = (Bird) birdClass.getConstructor().newInstance();
            Method setWalksMethod = birdClass.getDeclaredMethod("setWalks", boolean.class);
            Method walksMethod = birdClass.getDeclaredMethod("isWalks");
            boolean walks = (boolean) walksMethod.invoke(bird);

            assertFalse(walks);
            assertFalse(bird.isWalks());

            setWalksMethod.invoke(bird, true);

            boolean walks2 = (boolean) walksMethod.invoke(bird);
            assertTrue(walks2);
            assertTrue(bird.isWalks());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Якщо метод недоступний, робимо його доступним і викликаємо.
     */
    @Test
    public void givenMethod_whenSetAccessible_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Bird bird = (Bird) birdClass.getConstructor().newInstance();
            Method getPrivateMethod = birdClass.getDeclaredMethod("getPrivate");

            if (!getPrivateMethod.isAccessible()) {
                getPrivateMethod.setAccessible(true);
            }

            assertTrue(getPrivateMethod.isAccessible());
            String invokedResult = (String) getPrivateMethod.invoke(bird);
            assertEquals("private", invokedResult);
        } catch (Exception e) {
            fail();
        }
    }
}
