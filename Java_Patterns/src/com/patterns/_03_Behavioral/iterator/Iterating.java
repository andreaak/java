package com.patterns._03_Behavioral.iterator;

import java.util.Iterator;
import java.io.Serializable;
public interface Iterating extends Serializable{
    public Iterator getIterator();
}