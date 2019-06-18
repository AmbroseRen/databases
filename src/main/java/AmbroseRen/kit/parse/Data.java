package AmbroseRen.kit.parse;

import java.beans.Transient;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Data")
public class Data implements Serializable{

	private static final long serialVersionUID = -5369503606395918418L;
	
	@XmlElement(name="content")
	private content content;

	@XmlTransient
	public content getContent() {
		return content;
	}

	public void setContent(content content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Data [content=" + content + "]";
	}

	
}
