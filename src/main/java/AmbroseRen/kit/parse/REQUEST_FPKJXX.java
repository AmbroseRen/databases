package AmbroseRen.kit.parse;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class REQUEST_FPKJXX implements Serializable{

	private static final long serialVersionUID = -1626681630286757772L;
	
	@XmlElement(name="FPKJXX_FPTXX")
	private FPKJXX_FPTXX FPKJXX_FPTXX;
	@XmlElement(name="FPKJXX_XMXXS")
	private FPKJXX_XMXXS FPKJXX_XMXXS;
	
	@XmlTransient
	public FPKJXX_FPTXX getFPKJXX_FPTXX() {
		return FPKJXX_FPTXX;
	}
	public void setFPKJXX_FPTXX(FPKJXX_FPTXX fPKJXX_FPTXX) {
		FPKJXX_FPTXX = fPKJXX_FPTXX;
	}
	@XmlTransient
	public FPKJXX_XMXXS getFPKJXX_XMXXS() {
		return FPKJXX_XMXXS;
	}
	public void setFPKJXX_XMXXS(FPKJXX_XMXXS fPKJXX_XMXXS) {
		FPKJXX_XMXXS = fPKJXX_XMXXS;
	}
	@Override
	public String toString() {
		return "REQUEST_FPKJXX [FPKJXX_FPTXX=" + FPKJXX_FPTXX + ", FPKJXX_XMXXS=" + FPKJXX_XMXXS + "]";
	}
	
	
}
