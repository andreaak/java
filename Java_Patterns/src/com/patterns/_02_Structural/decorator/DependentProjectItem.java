package com.patterns._02_Structural.decorator;

public class DependentProjectItem extends ProjectDecorator{
    private ProjectItem dependentItem;
    
    public DependentProjectItem(){ }
    public DependentProjectItem(ProjectItem newDependentItem){
        dependentItem = newDependentItem;
    }
    
    public ProjectItem getDependentItem(){ return dependentItem; }
    
    public void setDependentItem(ProjectItem newDependentItem){ dependentItem = newDependentItem; }
    
    public String toString(){
        return getProjectItem().toString() + EOL_STRING
            + "\tProjectItem dependent on: " + dependentItem;
    }
}