package com.patterns._01_Creational.builder;

import java.io.Serializable;
public interface Location extends Serializable{
    public String getLocation();
    public void setLocation(String newLocation);
}