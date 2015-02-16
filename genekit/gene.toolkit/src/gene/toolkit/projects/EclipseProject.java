package gene.toolkit.projects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projectDescription")
public class EclipseProject {

	private String name = "";
	private String comment = "";
	private String projects = "";
	private List<BuildCommand> buildSpec = new ArrayList<BuildCommand>();
	private List<String> natures = new ArrayList<String>();


	@XmlElement(name = "name", required = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "comment", required = true)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@XmlElement(name = "projects", required = true)
	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	@XmlElementWrapper(name = "buildSpec", required = true)
	@XmlElement(name = "buildCommand", required = true)
	public List<BuildCommand> getBuildSpec() {
		return buildSpec;
	}

	public void setBuildSpec(List<BuildCommand> buildSpec) {
		this.buildSpec = buildSpec;
	}

	@XmlElementWrapper(name = "natures", required = true)
	@XmlElement(name = "nature", required = true)
	public List<String> getNatures() {
		return natures;
	}

	public void setNatures(List<String> natures) {
		this.natures = natures;
	}
	
	
	
}
