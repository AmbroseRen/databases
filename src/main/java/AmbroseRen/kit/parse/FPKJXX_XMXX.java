package AmbroseRen.kit.parse;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class FPKJXX_XMXX implements Serializable{

	private static final long serialVersionUID = 644254491420237803L;

	@XmlElement(name="XMMC")
	private String XMMC;
	@XmlElement(name="XMDW")
	private String XMDW;
	@XmlElement(name="GGXH")
	private String GGXH;
	@XmlElement(name="XMSL")
	private String XMSL;
	@XmlElement(name="HSBZ")
	private String HSBZ;
	@XmlElement(name="XMDJ")
	private String XMDJ;
	@XmlElement(name="FPHXZ")
	private String FPHXZ;
	@XmlElement(name="SPBM")
	private String SPBM;
	@XmlElement(name="SPBMJC")
	private String SPBMJC;
	@XmlElement(name="YHZCBS")
	private String YHZCBS;
	@XmlElement(name="LSLBS")
	private String LSLBS;
	@XmlElement(name="ZZSTSGL")
	private String ZZSTSGL;
	@XmlElement(name="XMJE")
	private String XMJE;
	@XmlElement(name="SL")
	private String SL;
	@XmlElement(name="SE")
	private String SE;
	
	@XmlTransient
	public String getXMMC() {
		return XMMC;
	}
	public void setXMMC(String xMMC) {
		XMMC = xMMC;
	}
	@XmlTransient
	public String getXMDW() {
		return XMDW;
	}
	public void setXMDW(String xMDW) {
		XMDW = xMDW;
	}
	@XmlTransient
	public String getGGXH() {
		return GGXH;
	}
	public void setGGXH(String gGXH) {
		GGXH = gGXH;
	}
	@XmlTransient
	public String getXMSL() {
		return XMSL;
	}
	public void setXMSL(String xMSL) {
		XMSL = xMSL;
	}
	@XmlTransient
	public String getHSBZ() {
		return HSBZ;
	}
	public void setHSBZ(String hSBZ) {
		HSBZ = hSBZ;
	}
	@XmlTransient
	public String getXMDJ() {
		return XMDJ;
	}
	public void setXMDJ(String xMDJ) {
		XMDJ = xMDJ;
	}
	@XmlTransient
	public String getFPHXZ() {
		return FPHXZ;
	}
	public void setFPHXZ(String fPHXZ) {
		FPHXZ = fPHXZ;
	}
	@XmlTransient
	public String getSPBM() {
		return SPBM;
	}
	public void setSPBM(String sPBM) {
		SPBM = sPBM;
	}
	@XmlTransient
	public String getSPBMJC() {
		return SPBMJC;
	}
	public void setSPBMJC(String sPBMJC) {
		SPBMJC = sPBMJC;
	}
	@XmlTransient
	public String getYHZCBS() {
		return YHZCBS;
	}
	public void setYHZCBS(String yHZCBS) {
		YHZCBS = yHZCBS;
	}
	@XmlTransient
	public String getLSLBS() {
		return LSLBS;
	}
	public void setLSLBS(String lSLBS) {
		LSLBS = lSLBS;
	}
	@XmlTransient
	public String getZZSTSGL() {
		return ZZSTSGL;
	}
	public void setZZSTSGL(String zZSTSGL) {
		ZZSTSGL = zZSTSGL;
	}
	@XmlTransient
	public String getXMJE() {
		return XMJE;
	}
	public void setXMJE(String xMJE) {
		XMJE = xMJE;
	}
	@XmlTransient
	public String getSL() {
		return SL;
	}
	public void setSL(String sL) {
		SL = sL;
	}
	@XmlTransient
	public String getSE() {
		return SE;
	}
	public void setSE(String sE) {
		SE = sE;
	}
	@Override
	public String toString() {
		return "FPKJXX_XMXX [XMMC=" + XMMC + ", XMDW=" + XMDW + ", GGXH=" + GGXH + ", XMSL=" + XMSL + ", HSBZ=" + HSBZ
				+ ", XMDJ=" + XMDJ + ", FPHXZ=" + FPHXZ + ", SPBM=" + SPBM + ", SPBMJC=" + SPBMJC + ", YHZCBS=" + YHZCBS
				+ ", LSLBS=" + LSLBS + ", ZZSTSGL=" + ZZSTSGL + ", XMJE=" + XMJE + ", SL=" + SL + ", SE=" + SE + "]";
	}
	
}
