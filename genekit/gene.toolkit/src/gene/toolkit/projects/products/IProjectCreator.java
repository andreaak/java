package gene.toolkit.projects.products;

public interface IProjectCreator {
	
	void createEclipseProject();
	
	final String JAVA_BUILDER = "org.eclipse.jdt.core.javabuilder";
	final String JAVA_NATURE = "org.eclipse.jdt.core.javanature";
	final String JAVA_CONTAINER = "org.eclipse.jdt.launching.JRE_CONTAINER";
}
