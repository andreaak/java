package gene.toolkit.projects.products;

import gene.toolkit.Activator;
import gene.toolkit.model.Entity;
import gene.toolkit.model.EntityFactory;
import gene.toolkit.projects.BuildCommand;
import gene.toolkit.projects.ClasspathEntry;
import gene.toolkit.projects.EclipseClasspath;
import gene.toolkit.projects.EclipseProject;
import gene.toolkit.utils.LinkManager;
import gene.toolkit.System;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GeneProjectCreator implements IProjectCreator {

   private Entity entity;
   
   public GeneProjectCreator(System system) {
      entity = EntityFactory.getEntity(system);
   }
   
   @Override
	public void createEclipseProject() {
		EclipseProject project = new EclipseProject();
		project.setName(Activator.getDefault().getPreferenceStore().getString(entity.getProjectName()));
		BuildCommand cmd = new BuildCommand();
		cmd.setName(JAVA_BUILDER);
		project.getBuildSpec().add(cmd);
		project.getNatures().add(JAVA_NATURE);

		EclipseClasspath cp = new EclipseClasspath();

		cp.getEntries().add(new ClasspathEntry("src", "src"));
		cp.getEntries().add(new ClasspathEntry("src", "generated"));
		cp.getEntries().add(new ClasspathEntry("src", "/" + Activator.getDefault().getPreferenceStore().getString(
		      EntityFactory.getEntity(gene.toolkit.System.GCM).getProjectName())));
		cp.getEntries().add(new ClasspathEntry("con", JAVA_CONTAINER));
		cp.getEntries().add(new ClasspathEntry("output", Activator.getDefault().getPreferenceStore().getString(entity.getProjectOut())));

		String[] libs = Activator.getDefault().getPreferenceStore()
				.getString(entity.getProjectDepends()).split("\\|");

		for (String lib : libs) {
			cp.getEntries().add(new ClasspathEntry("lib", lib));
		}

		try {
			JAXBContext ctx = JAXBContext.newInstance(EclipseProject.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(project, new File(entity.getProjectFile()));

			ctx = JAXBContext.newInstance(EclipseClasspath.class);
			m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(cp, new File(entity.getProjectClassPathFile()));
		} catch (JAXBException e) {
			Activator.getDefault().getConsole().newMessageStream().println(e.getMessage());
		}
		
		String outputSymlink = entity.getProjectFullPath() + File.separator + 
		      Activator.getDefault().getPreferenceStore().getString(entity.getProjectOut());
		
		try {
			LinkManager.createJunction(outputSymlink, entity.getDistFullPath());
		} catch (IOException e) {
			Activator.getDefault().getConsole().newMessageStream().println(e.getMessage());
		}
	}

}
