package gene.toolkit.projects;

import javax.xml.bind.annotation.XmlAttribute;

public class ClasspathEntry {

	private String kind = "";
	private String path = "";
	
	public ClasspathEntry() {}
	
	public ClasspathEntry(String kind, String path) {
		this.kind = kind;
		this.path = path;
	}
	
	@XmlAttribute(name = "kind", required = true)
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	@XmlAttribute(name = "path", required = true)
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}
