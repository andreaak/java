package com.patterns._04_Other.transaction;

import java.io.Serializable;
public interface Location extends Serializable{
    public String getLocation();
    public void setLocation(String newLocation);
}