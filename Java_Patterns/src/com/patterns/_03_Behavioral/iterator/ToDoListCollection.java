package com.patterns._03_Behavioral.iterator;

public interface ToDoListCollection extends Iterating{
    public void add(ToDoList list);
    public void remove(ToDoList list);
    public int getNumberOfItems();
}