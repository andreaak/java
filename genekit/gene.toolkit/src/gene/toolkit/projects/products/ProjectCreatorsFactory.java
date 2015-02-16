package gene.toolkit.projects.products;

import gene.toolkit.System;

public class ProjectCreatorsFactory {

	public static IProjectCreator getProjectCreator(System system) {
		return new GeneProjectCreator(system);
	}
	
}
