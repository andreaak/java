package com.java._13_Serialization._04_Externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
    private int id;
    private  String username;

    public Student() {
        System.out.println("Student default Constructor");
    }

    public Student(int id, String username) {
        this.id = id;
        this.username = username;
        System.out.println("Student Constructor");
    }

    @Override
    public void writeExternal( ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(username);
    }

    @Override
    public void readExternal( ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        username = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

