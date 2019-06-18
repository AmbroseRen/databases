package AmbroseRen.kit.parse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class globalInfo implements Serializable{

	private static final long serialVersionUID = 8338759921739385070L;

	@XmlElement(name="version")
	private String version;	
	@XmlElement(name="interfaceCode")
	private String interfaceCode;	
	@XmlElement(name="token")
	private String token;	

//	@DateTimeFormat(pattern = "yyyy-MM-dd") //入参 
//	@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss") 
	Date now =new Date();
	SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
	@XmlElement(name="requestTime")
	private String requestTime=sdf.format(now);
	
	@XmlTransient	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@XmlTransient	
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	@XmlTransient
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@XmlTransient
	public String getRequestTime() {
		return requestTime;
	}
	public String setRequestTime(String requestTime) {
		return this.requestTime = requestTime;
	}
	@Override
	public String toString() {
		return "globalInfo [interfaceCode=" + interfaceCode + ", token=" + token + ", requestTime=" + requestTime + "]";
	}


}
