package com.java._16_StreamAPI._02_Stream;

import com.java._16_StreamAPI._02_Stream.models.Employee;
import com.java._16_StreamAPI._02_Stream.models.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_ObjectsTest {
    @Test
    public void TestStreamAPI1Sort(){
        List<Person> people = createPersonList();
        List<Person> people1 = people.stream()
                .distinct()
                .filter(person -> person.getAge() > 18)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        for (Person person: people1){
            System.out.println(person);
        }
        /*
        Person{name='Наталія', age=20, city='Харків', position='Розробник'}
        Person{name='Софія', age=24, city='Кривий Ріг', position='Аналітик'}
        Person{name='Іван', age=25, city='Київ', position='Менеджер'}
        Person{name='Анна', age=27, city='Дніпро', position='Директор'}
        Person{name='Ірина', age=29, city='Запоріжжя', position='Менеджер'}
        Person{name='Марія', age=30, city='Львів', position='Інженер'}
        Person{name='Іван', age=33, city='Львів', position='Менеджер'}
        Person{name='Петро', age=35, city='Дніпро', position='Розробник'}
         */

    }

    @Test
    public void TestStreamAPI2Grouped(){
        List<Person> people = createPersonList();
        Map<String, List<Person>> grouped = people.stream()
                .distinct()
                .collect(Collectors.groupingBy(person -> person.getCity()));

        grouped.forEach((city, peopleInCity) -> {
            System.out.println("City: "+ city);
            peopleInCity.forEach(person -> System.out.println(person));
        });

        /*
        City: Одеса
        Person{name='Олег', age=15, city='Одеса', position=''}
        City: Кривий Ріг
        Person{name='Софія', age=24, city='Кривий Ріг', position='Аналітик'}
        City: Львів
        Person{name='Марія', age=30, city='Львів', position='Інженер'}
        Person{name='Іван', age=33, city='Львів', position='Менеджер'}
        City: Київ
        Person{name='Іван', age=25, city='Київ', position='Менеджер'}
        City: Дніпро
        Person{name='Петро', age=35, city='Дніпро', position='Розробник'}
        Person{name='Анна', age=27, city='Дніпро', position='Директор'}
        City: Харків
        Person{name='Наталія', age=16, city='Харків', position=''}
        Person{name='Наталія', age=20, city='Харків', position='Розробник'}
        City: Запоріжжя
        Person{name='Ірина', age=29, city='Запоріжжя', position='Менеджер'}
         */
    }

    @Test
    public void TestStreamAPI3Map(){
        ArrayList<Person> people = new ArrayList<>(createPersonList());

        Stream<Employee> employees = people.stream()
                .filter(person -> !person.getPosition().isEmpty())
                .distinct()
                .map(person -> {
                    Employee employee = new Employee();
                    employee.setName(person.getName());
                    employee.setAge(person.getAge());
                    employee.setPosition(person.getPosition());
                    return employee;
                })/*.collect(Collectors.toList())*/;

        List<Employee> employeeList = employees.collect(Collectors.toList());
        employeeList.stream().forEach(System.out::println);

        people.add(new Person("Test", 18, "ZP", "TEST"));
        //employees.collect(Collectors.toList()).stream().forEach(System.out::println);//ERROR

        /*
        Employee{name='Іван', age=25, position='Менеджер'}
        Employee{name='Марія', age=30, position='Інженер'}
        Employee{name='Наталія', age=20, position='Розробник'}
        Employee{name='Петро', age=35, position='Розробник'}
        Employee{name='Ірина', age=29, position='Менеджер'}
        Employee{name='Анна', age=27, position='Директор'}
        Employee{name='Іван', age=33, position='Менеджер'}
        Employee{name='Софія', age=24, position='Аналітик'}
         */
    }

    @Test
    public void TestStreamAP41UniquePositions(){
        List<Person> people = createPersonList();
        String collected = people.stream()
                .map(person -> person.getPosition())
                .filter(position -> !position.isEmpty())
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(collected);
        /*
        Менеджер, Інженер, Розробник, Директор, Аналітик
         */
    }

    private List<Person> createPersonList(){
        return Arrays.asList(
                new Person("Іван", 25, "Київ", "Менеджер"),
                new Person("Марія", 30, "Львів", "Інженер"),
                new Person("Олег", 15, "Одеса", ""),
                new Person("Наталія", 16, "Харків", ""),
                new Person("Наталія", 20, "Харків", "Розробник"),
                new Person("Петро", 35, "Дніпро", "Розробник"),
                new Person("Петро", 35, "Дніпро", "Розробник"),
                new Person("Ірина", 29, "Запоріжжя", "Менеджер"),
                new Person("Анна", 27, "Дніпро", "Директор"),
                new Person("Іван", 33, "Львів", "Менеджер"),
                new Person("Софія", 24, "Кривий Ріг", "Аналітик"),
                new Person("Софія", 24, "Кривий Ріг", "Аналітик")
        );
    }
}
