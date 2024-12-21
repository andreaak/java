package com.java._02_Classes._04_Ctor;

public class Animal {
    private int age;
    private int height;

    // объявление конструктора
    // создали конструктор с параметрами
    // конструктор по умолчанию создан не будет, пока Вы это не сделаете руками
    //Конструктор не может быть static, abstract или final
    public Animal(int age) {
        this.age = age;
    }

    // работа ключевого слова this
    public Animal(int age, int height) {
        this.age = age;
        this.height = height;
    }
}

