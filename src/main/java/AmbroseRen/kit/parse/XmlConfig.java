package AmbroseRen.kit.parse;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="interface")
public class XmlConfig implements Serializable{

	private static final long serialVersionUID = 5636306863575037019L;
	
	@XmlElement(name="globalInfo")
	private globalInfo globalInfo;
	@XmlElement(name="Data")
	private Data Data;

	@XmlTransient
	public globalInfo getGlobalInfo() {
		return globalInfo;
	}

	public void setGlobalInfo(globalInfo globalInfo) {
		this.globalInfo = globalInfo;
	}

	@XmlTransient
	public Data getData() {
		return Data;
	}

	public void setData(Data data) {
		Data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "XmlConfig [globalInfo=" + globalInfo + ", Data=" + Data + ", getGlobalInfo()=" + getGlobalInfo()
				+ ", getData()=" + getData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
