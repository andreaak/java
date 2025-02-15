package com.java._11_Annotations._01_Base;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Mammal {
    /**
     * @return sound of a mammal
     */
    String sound() default "Meow";

    /**
     * @return color of mammal
     */
    Color[] color() default Color.BLACK;
}

// @Target(ElementType.METHOD) - аннотация может использоваться только с методом класса.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface HasHair {
    int length() default 10;
}