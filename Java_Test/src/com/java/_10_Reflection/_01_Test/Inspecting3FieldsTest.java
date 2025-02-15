package com.java._10_Reflection._01_Test;

import com.java._10_Reflection._01_Test.models.Bird;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class Inspecting3FieldsTest {
    /**
     * Метод getFields() повертає всі доступні публічні поля даного класу.
     * Він поверне всі загальнодоступні поля як у класі, так і в усіх суперкласах.
     */
    @Test
    public void givenClass_whenGetsPublicFields_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Field[] fields = birdClass.getFields();

            assertEquals(1, fields.length);
            assertEquals("CATEGORY", fields[0].getName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Метод getField() повертає лише один об’єкт Field, беручи назву поля.
     */
    @Test
    public void givenClass_whenGetsPublicFieldByName_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Field field = birdClass.getField("CATEGORY");

            assertEquals("CATEGORY", field.getName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Метод getDeclaredFields() повертає усі поля (в тому числі private, protected), оголошені в класі.
     */
    @Test
    public void givenClass_whenGetsDeclaredFields_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Field[] fields = birdClass.getDeclaredFields();

            assertEquals(1, fields.length);
            assertEquals("walks", fields[0].getName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Отримання поля за його назвою.
     */
    @Test
    public void givenClassField_whenGetsType_thenCorrect() {
        try {
            Field field = Class.forName("com.java._10_Reflection._01_Test.models.Bird")
                    .getDeclaredField("walks");
            Class<?> fieldClass = field.getType();

            assertEquals("boolean", fieldClass.getSimpleName());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Щоб отримати значення поля, або встановити йому нове значення,
     * ми повинні спочатку зробити його доступним, викликавши метод
     * setAccessible() для об’єкта Field і передавши йому логічне значення true.
     */
    @Test
    public void givenClassField_whenSetsAndGetsValue_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Bird bird = (Bird) birdClass.getConstructor().newInstance();
            Field field = birdClass.getDeclaredField("walks");
            field.setAccessible(true);

            assertFalse(field.getBoolean(bird));
            assertFalse(bird.isWalks());

            field.set(bird, true);

            assertTrue(field.getBoolean(bird));
            assertTrue(bird.isWalks());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Якщо об’єкти Field оголошені як public static, нам не потрібен екземпляр класу, який їх містить.
     * Ми можемо просто передати null замість нього і все одно отримати значення поля за замовчуванням.
     */
    @Test
    public void givenClassField_whenGetsAndSetsWithNull_thenCorrect() {
        try {
            Class<?> birdClass = Class.forName("com.java._10_Reflection._01_Test.models.Bird");
            Field field = birdClass.getField("CATEGORY");
            field.setAccessible(true);

            assertEquals("domestic", field.get(null));
        } catch (Exception e) {
            fail();
        }
    }
}
