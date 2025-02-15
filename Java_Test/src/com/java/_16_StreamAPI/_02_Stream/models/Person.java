package com.java._16_StreamAPI._02_Stream.models;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String city;
    private String position;

    public Person(String name, int age, String city, String position) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(city, person.city) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city, position);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
