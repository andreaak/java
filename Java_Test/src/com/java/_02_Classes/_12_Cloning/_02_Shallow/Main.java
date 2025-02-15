package com.java._02_Classes._12_Cloning._02_Shallow;

import org.junit.Test;

public class Main {

    @Test
    public void TestCloning1() {
        Group group = new Group(1);
        Student student = new Student("Yevhenii", 25, group);

        try {
            Student cloneStudent = (Student) student.clone();
            System.out.println(student);
            System.out.println(cloneStudent);

            cloneStudent.name = "Robert";
            cloneStudent.group.id = 10;

            System.out.println("After cloning");

            System.out.println(student);
            System.out.println(cloneStudent);

            /*
            Student{name='Yevhenii', age=25, group=Group{id=1}}
            Student{name='Yevhenii', age=25, group=Group{id=1}}
            After cloning
            Student{name='Yevhenii', age=25, group=Group{id=10}}
            Student{name='Robert', age=25, group=Group{id=10}}
             */
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
