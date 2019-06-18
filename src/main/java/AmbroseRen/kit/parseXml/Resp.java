package AmbroseRen.kit.parseXml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="RtnVal")
public class Resp implements Serializable {
	
	private static final long serialVersionUID = -9186519188324702061L;
	
	@XmlElement(name="RtnID")
	private String RtnID;
	@XmlElement(name="RtnData")
	private String RtnData;
	
	@XmlTransient
	public String getRtnID() {
		return RtnID;
	}
	public void setRtnID(String rtnID) {
		RtnID = rtnID;
	}
	@XmlTransient
	public String getRtnData() {
		return RtnData;
	}
	public void setRtnData(String rtnData) {
		RtnData = rtnData;
	}
	@Override
	public String toString() {
		return "Resp [RtnID=" + RtnID + ", RtnData=" + RtnData + "]";
	}
	
	
	
}
