package gene.toolkit.handlers;

import gene.toolkit.Activator;
import gene.toolkit.System;
import gene.toolkit.model.Entity;
import gene.toolkit.model.EntityFactory;
import gene.toolkit.projects.products.ProjectCreatorsFactory;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ProjectsCreationThread implements Runnable {

	@Override
	public void run() {
        MessageConsole console = Activator.getDefault().getConsole();
		
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		MessageConsoleStream out = console.newMessageStream();
		console.clearConsole();
		
		try {
			
         generateProject(out, System.GCM);
         generateProject(out, System.MOL);
         generateProject(out, System.CTG);
         generateProject(out, System.FLW);     
         generateProject(out, System.DXP);
         generateProject(out, System.HLA); 
         generateProject(out, System.ACC);
         generateProject(out, System.MIC); 
         generateProject(out, System.LAB5);
         
         out.println("-----------------------------------------------------");
		   out.println("Completed.");
		} catch (CoreException err) {
		    out.println(err.getMessage());
		}
				
	}

   private void generateProject(MessageConsoleStream out, System system) throws CoreException {
      
      Entity entity = EntityFactory.getEntity(system);
      out.println("Generating project " + Activator.getDefault().getPreferenceStore().getString(entity.getProjectName()) + "...");
      ProjectCreatorsFactory.getProjectCreator(system).createEclipseProject();
      addProjectToWorkspace(entity.getProjectFile());
   }
	
	private void addProjectToWorkspace(String theLocation) throws CoreException {
	    IProjectDescription theDesc = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(theLocation));
	    IProject theProject = ResourcesPlugin.getWorkspace().getRoot().getProject(theDesc.getName());
	    theProject.create(theDesc, null);
	}

}
