package com.patterns._03_Behavioral.command;

import java.io.Serializable;
public interface Location extends Serializable{
    public String getLocation();
    public void setLocation(String newLocation);
}