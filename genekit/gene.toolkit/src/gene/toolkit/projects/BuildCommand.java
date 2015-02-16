package gene.toolkit.projects;

import javax.xml.bind.annotation.XmlElement;

public class BuildCommand {

	private String name = "";
	private String arguments = "";
	
	@XmlElement(name = "name", required = true)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "arguments", required = true)
	public String getArguments() {
		return arguments;
	}
	
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
		
}
