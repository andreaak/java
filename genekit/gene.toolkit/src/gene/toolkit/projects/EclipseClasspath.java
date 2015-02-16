package gene.toolkit.projects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classpath")
public class EclipseClasspath {
	
	private List<ClasspathEntry> entries = new ArrayList<ClasspathEntry>();

	@XmlElement(name = "classpathentry", required = true)
	public List<ClasspathEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ClasspathEntry> entries) {
		this.entries = entries;
	}


}
