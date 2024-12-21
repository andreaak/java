package com.java._02_Classes._04_Ctor;

import org.junit.Test;

public class Main {
    @Test
    public void Test1() {

        AnimalDefaultCtor animal = new AnimalDefaultCtor();
        System.out.println(animal);

        // Компилятор нам не даст возможности создать объект с приватным консруктором
        //Animal animal2 = new Animal(true);


    }

    @Test
    public void Test2() {

        // создание обьектов с разными параметрами
        AnimalOverload animalDefault = new AnimalOverload();
        AnimalOverload animalWithOneParameter = new AnimalOverload(22);
        AnimalOverload animalWithTwoParameters = new AnimalOverload(23, 61);

        // вывод параметров объеков
        System.out.println("Age: " + animalDefault.getAge() + "; Height: " + animalDefault.getHeight());
        System.out.println("Age: " + animalWithOneParameter.getAge() + "; Height: " + animalWithOneParameter.getHeight());
        System.out.println("Age: " + animalWithTwoParameters.getAge() + "; Height: " + animalWithTwoParameters.getHeight());
    }

    @Test
    public void Test3() {

        // пример создания объектов с разными параметрами
        AnimalFromCtor animalDefault = new AnimalFromCtor();
        AnimalFromCtor animalWithOneParameter = new AnimalFromCtor(12);
        AnimalFromCtor animalWithTwoParameters = new AnimalFromCtor(14, 50);

        // выводим на экран наши объекты
        System.out.println("Age: " + animalDefault.getAge() + "; Height: " + animalDefault.getHeight());
        System.out.println("Age: " + animalWithOneParameter.getAge() + "; Height: " + animalWithOneParameter.getHeight());
        System.out.println("Age: " + animalWithTwoParameters.getAge() + "; Height: " + animalWithTwoParameters.getHeight());
    }
}
