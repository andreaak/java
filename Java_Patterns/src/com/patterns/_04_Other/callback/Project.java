package com.patterns._04_Other.callback;

import java.util.ArrayList;

public class Project implements ProjectItem{
    private String name;
    private String description;
    private ArrayList<ProjectItem> projectItems = new ArrayList<>();
    
    public Project(){ }
    public Project(String newName, String newDescription){
        name = newName;
        description = newDescription;
    }
    
    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public ArrayList<ProjectItem> getProjectItems(){ return projectItems; }
    
    public void setName(String newName){ name = newName; }
    public void setDescription(String newDescription){ description = newDescription; }
    
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
    
    public String toString(){ return name + ", " + description; }
}