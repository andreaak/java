package com.patterns._04_Other.workerThread;

import java.io.Serializable;
public interface Contact extends Serializable{
    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String SPACE = " ";
    public String getFirstName();
    public String getLastName();
    public String getTitle();
    public String getOrganization();
    
    public void setFirstName(String newFirstName);
    public void setLastName(String newLastName);
    public void setTitle(String newTitle);
    public void setOrganization(String newOrganization);
}