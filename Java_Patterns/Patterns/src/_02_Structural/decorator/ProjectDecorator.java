package _02_Structural.decorator;

public abstract class ProjectDecorator implements ProjectItem{
    private ProjectItem projectItem;
    
    protected ProjectItem getProjectItem(){ return projectItem; }
    public void setProjectItem(ProjectItem newProjectItem){ projectItem = newProjectItem; }
    
    public double getTimeRequired(){
        return projectItem.getTimeRequired();
    }
}