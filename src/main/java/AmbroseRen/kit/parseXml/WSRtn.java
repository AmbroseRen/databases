package AmbroseRen.kit.parseXml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class WSRtn implements Serializable {

	private static final long serialVersionUID = -6805545169308871406L;
	
	@XmlElement(name="RtnVal")
	private Resp resp;
	
	@XmlElement(name="RtnDt")
	private ICcard card;
	
	@XmlTransient
	public Resp getResp() {
		return resp;
	}

	public void setResp(Resp resp) {
		this.resp = resp;
	}
	@XmlTransient
	public ICcard getCard() {
		return card;
	}

	public void setCard(ICcard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "WSRtn [resp=" + resp + ", card=" + card + "]";
	}
	
	
	
}
