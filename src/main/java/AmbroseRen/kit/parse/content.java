package AmbroseRen.kit.parse;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="content")
public class content implements Serializable{

	private static final long serialVersionUID = 7803111727093892976L;

	@XmlElement(name="REQUEST_FPKJXX")
	private REQUEST_FPKJXX REQUEST_FPKJXX;

	@XmlTransient
	public REQUEST_FPKJXX getREQUEST_FPKJXX() {
		return REQUEST_FPKJXX;
	}

	public void setREQUEST_FPKJXX(REQUEST_FPKJXX rEQUEST_FPKJXX) {
		REQUEST_FPKJXX = rEQUEST_FPKJXX;
	}

	@Override
	public String toString() {
		return "content [REQUEST_FPKJXX=" + REQUEST_FPKJXX + "]";
	}
	
	
}
