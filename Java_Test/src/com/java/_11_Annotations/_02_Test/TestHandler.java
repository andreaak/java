package com.java._11_Annotations._02_Test;

import java.lang.reflect.Method;

public class TestHandler {
    // Принимает массив Классов(который описывает свои классы)
    public static boolean test(Class<?>... ls) {
        try {
            for (Class<?> cl : ls) {
                // Получаем список методов
                Method[] methods = cl.getDeclaredMethods();
                for (Method method : methods) {
                    // Если какой либо метод аннотирован аннотацией TestAnno, то мы вызываем этот метод
                    // С помощью рефлексии
                    if (method.isAnnotationPresent(TestAnno.class)) {
                        // Чтобы вызвать статический метод, то
                        // передаем параметр null, вместо объекта
                        Boolean b = (Boolean) method.invoke(null, new Object[]{});
                        if (!b) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
