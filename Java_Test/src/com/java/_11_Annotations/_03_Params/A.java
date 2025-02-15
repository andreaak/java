package com.java._11_Annotations._03_Params;

import java.lang.annotation.*;

/**
 * Created by Yevhenii Tykhonov.
 */
//@MyAnno(value = "World", i = 25)
@MyAnno2("Hello")
@MyAnno2("World")
public class A {
    public void print() {
        System.out.println("A");
    }
}

@Deprecated
class B extends A {
    @Deprecated
//    @MyAnno("World")
    private int i;

    @Deprecated
    @Override
    public void print() {
        System.out.println("B");
    }
}

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@interface MyAnno {
    //    public abstract String str() default "Hello" + new String("World");
//    String value();
    MyAnno2[] value();
    String str() default "Hello";

    int i() default 10 + 10;
//    enum MyEnum {
//        BLACK, WHITE, GREEN, ORANGE
//    }
//    Integer i2();
//    Object o();
}

@Repeatable(MyAnno.class)   // Java 8
@interface MyAnno2 {
    String value();
}

@FunctionalInterface
        //  JDK8
interface MyOwnInterf {
    int i();
}