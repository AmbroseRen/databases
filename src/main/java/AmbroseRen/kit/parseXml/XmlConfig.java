package AmbroseRen.kit.parseXml;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="string",namespace="http://tjwws.net/")
public class XmlConfig implements Serializable {
	
	private static final long serialVersionUID = -255917002716907452L;
	
	@XmlElement(name="WSRtn")
	private WSRtn WSRtn;
	
	@XmlTransient
	public WSRtn getWSRtn() {
		return WSRtn;
	}

	public void setWSRtn(WSRtn wSRtn) {
		WSRtn = wSRtn;
	}

	@Override
	public String toString() {
		return "XmlConfig [WSRtn=" + WSRtn + "]";
	}
	
}
