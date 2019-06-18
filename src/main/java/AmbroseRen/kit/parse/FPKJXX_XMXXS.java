package AmbroseRen.kit.parse;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="FPKJXX_XMXXS")
public class FPKJXX_XMXXS implements Serializable{

	private static final long serialVersionUID = 2985402184677473021L;

	@XmlElement(name="FPKJXX_XMXX")
	private FPKJXX_XMXX FPKJXX_XMXX;

	@XmlTransient
	public FPKJXX_XMXX getFPKJXX_XMXX() {
		return FPKJXX_XMXX;
	}

	public void setFPKJXX_XMXX(FPKJXX_XMXX fPKJXX_XMXX) {
		FPKJXX_XMXX = fPKJXX_XMXX;
	}

	@Override
	public String toString() {
		return "FPKJXX_XMXXS [FPKJXX_XMXX=" + FPKJXX_XMXX + "]";
	}
	
	
}
