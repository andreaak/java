package com.java._11_Annotations._01_Base;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    @Test
    public void TestAnnotation1() {
        try {
            AnotherDog dog = new AnotherDog();
            Class<?> cl = dog.getClass();
            Annotation[] classAnnotations = cl.getAnnotations();

            System.out.println(cl.getName() + "\nAnnotations:");
            for (Annotation annotation : classAnnotations) {
                System.out.println("\t" + annotation);
            }
            Method[] classMethods = cl.getMethods();
            System.out.println("Method annotations:");
            for (Method method : classMethods) {
                Annotation[] methodAnnotations = method.getAnnotations();
                if (methodAnnotations.length > 0) {
                    System.out.println("\t" + method.getName() + "():");
                }
                for (Annotation annotation : methodAnnotations) {
                    System.out.println("\t" + annotation);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
        com.java._11_Annotations._01_Base.AnotherDog
        Annotations:
            @com.java._11_Annotations._01_Base.Mammal(color={GREY}, sound="Woof")
        Method annotations:
            hair():
            @com.java._11_Annotations._01_Base.HasHair(length=10)
            hashCode():
            @jdk.internal.vm.annotation.IntrinsicCandidate()
            getClass():
            @jdk.internal.vm.annotation.IntrinsicCandidate()
            notify():
            @jdk.internal.vm.annotation.IntrinsicCandidate()
            notifyAll():
            @jdk.internal.vm.annotation.IntrinsicCandidate()
         */
    }
}