package com.patterns._03_Behavioral.observer;

public interface TaskChangeObserver{
    public void taskAdded(Task task);
    public void taskChanged(Task task);
    public void taskSelected(Task task);
}