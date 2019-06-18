package AmbroseRen.kit.parse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.org.apache.bcel.internal.generic.NEW;

@XmlRootElement(name="FPKJXX_FPTXX")
public class FPKJXX_FPTXX implements Serializable{

	private static final long serialVersionUID = 3274039550659984132L;
	
	@XmlElement(name="NSRSBH")
	private String NSRSBH;
	@XmlElement(name="FJH")
	private String FJH;
	@XmlElement(name="NSRMC")
	private String NSRMC;
	@XmlElement(name="XHF_DZ")
	private String XHF_DZ;
	@XmlElement(name="XHF_DH")
	private String XHF_DH;
	@XmlElement(name="XHF_YHZH")
	private String XHF_YHZH;
	@XmlElement(name="GHFMC")
	private String GHFMC;
	@XmlElement(name="GHF_NSRSBH")
	private String GHF_NSRSBH;
	@XmlElement(name="GHF_DZ")
	private String GHF_DZ;
	@XmlElement(name="GHF_GDDH")
	private String GHF_GDDH;
	@XmlElement(name="GHF_YHZH")
	private String GHF_YHZH;
	@XmlElement(name="KPY")
	private String KPY;
	@XmlElement(name="SKY")
	private String SKY;
	@XmlElement(name="FHR")
	private String FHR;
	@XmlElement(name="KPLX")
	private String KPLX;
	@XmlElement(name="YFP_DM")
	private String YFP_DM;
	@XmlElement(name="YFP_HM")
	private String YFP_HM;
	@XmlElement(name="KPHJJE")
	private String KPHJJE;
	@XmlElement(name="HJBHSJE")
	private String HJBHSJE;
	@XmlElement(name="HJSE")
	private String HJSE;
	@XmlElement(name="BZ")
	private String BZ;
	@XmlElement(name="BB")
	private String BB;
	@XmlElement(name="WB")
	private String WB;
	@XmlElement(name="FPZL")
	private String FPZL;
	@XmlElement(name="KPRQ")
	Date now =new Date();
	SimpleDateFormat sdfs =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String KPRQ=sdfs.format(now);
	@XmlElement(name="FP_DM")
	private String FP_DM;
	@XmlElement(name="FP_HM")
	private String FP_HM;
	@XmlElement(name="FPMW")
	private String FPMW;
	@XmlElement(name="JYM")
	private String JYM;
	@XmlElement(name="EWM")
	private String EWM;
	@XmlElement(name="JQBH")
	private String JQBH;
	@XmlElement(name="PDF")
	private String PDF;
	
	@XmlTransient
	public String getNSRSBH() {
		return NSRSBH;
	}
	public void setNSRSBH(String nSRSBH) {
		NSRSBH = nSRSBH;
	}
	@XmlTransient
	public String getFJH() {
		return FJH;
	}
	public void setFJH(String fJH) {
		FJH = fJH;
	}
	@XmlTransient
	public String getNSRMC() {
		return NSRMC;
	}
	public void setNSRMC(String nSRMC) {
		NSRMC = nSRMC;
	}
	@XmlTransient
	public String getXHF_DZ() {
		return XHF_DZ;
	}
	public void setXHF_DZ(String xHF_DZ) {
		XHF_DZ = xHF_DZ;
	}
	@XmlTransient
	public String getXHF_DH() {
		return XHF_DH;
	}
	public void setXHF_DH(String xHF_DH) {
		XHF_DH = xHF_DH;
	}
	@XmlTransient
	public String getXHF_YHZH() {
		return XHF_YHZH;
	}
	public void setXHF_YHZH(String xHF_YHZH) {
		XHF_YHZH = xHF_YHZH;
	}
	@XmlTransient
	public String getGHFMC() {
		return GHFMC;
	}
	public void setGHFMC(String gHFMC) {
		GHFMC = gHFMC;
	}
	@XmlTransient
	public String getGHF_NSRSBH() {
		return GHF_NSRSBH;
	}
	public void setGHF_NSRSBH(String gHF_NSRSBH) {
		GHF_NSRSBH = gHF_NSRSBH;
	}
	@XmlTransient
	public String getGHF_DZ() {
		return GHF_DZ;
	}
	public void setGHF_DZ(String gHF_DZ) {
		GHF_DZ = gHF_DZ;
	}
	@XmlTransient
	public String getGHF_GDDH() {
		return GHF_GDDH;
	}
	public void setGHF_GDDH(String gHF_GDDH) {
		GHF_GDDH = gHF_GDDH;
	}
	@XmlTransient
	public String getGHF_YHZH() {
		return GHF_YHZH;
	}
	public void setGHF_YHZH(String gHF_YHZH) {
		GHF_YHZH = gHF_YHZH;
	}
	@XmlTransient
	public String getKPY() {
		return KPY;
	}
	public void setKPY(String kPY) {
		KPY = kPY;
	}
	@XmlTransient
	public String getSKY() {
		return SKY;
	}
	public void setSKY(String sKY) {
		SKY = sKY;
	}
	@XmlTransient
	public String getFHR() {
		return FHR;
	}
	public void setFHR(String fHR) {
		FHR = fHR;
	}
	@XmlTransient
	public String getKPLX() {
		return KPLX;
	}
	public void setKPLX(String kPLX) {
		KPLX = kPLX;
	}
	@XmlTransient
	public String getYFP_DM() {
		return YFP_DM;
	}
	public void setYFP_DM(String yFP_DM) {
		YFP_DM = yFP_DM;
	}
	@XmlTransient
	public String getYFP_HM() {
		return YFP_HM;
	}
	public void setYFP_HM(String yFP_HM) {
		YFP_HM = yFP_HM;
	}
	@XmlTransient
	public String getKPHJJE() {
		return KPHJJE;
	}
	public void setKPHJJE(String kPHJJE) {
		KPHJJE = kPHJJE;
	}
	@XmlTransient
	public String getHJBHSJE() {
		return HJBHSJE;
	}
	public void setHJBHSJE(String hJBHSJE) {
		HJBHSJE = hJBHSJE;
	}
	@XmlTransient
	public String getHJSE() {
		return HJSE;
	}
	public void setHJSE(String hJSE) {
		HJSE = hJSE;
	}
	@XmlTransient
	public String getBZ() {
		return BZ;
	}
	public void setBZ(String bZ) {
		BZ = bZ;
	}
	@XmlTransient
	public String getBB() {
		return BB;
	}
	public void setBB(String bB) {
		BB = bB;
	}
	@XmlTransient
	public String getWB() {
		return WB;
	}
	public void setWB(String wB) {
		WB = wB;
	}
	@XmlTransient
	public String getFPZL() {
		return FPZL;
	}
	public void setFPZL(String fPZL) {
		FPZL = fPZL;
	}
	@XmlTransient
	public String getKPRQ() {
		return KPRQ;
	}
	public void setKPRQ(String kPRQ) {
		KPRQ = kPRQ;
	}
	@XmlTransient
	public String getFP_DM() {
		return FP_DM;
	}
	public void setFP_DM(String fP_DM) {
		FP_DM = fP_DM;
	}
	@XmlTransient
	public String getFP_HM() {
		return FP_HM;
	}
	public void setFP_HM(String fP_HM) {
		FP_HM = fP_HM;
	}
	@XmlTransient
	public String getFPMW() {
		return FPMW;
	}
	public void setFPMW(String fPMW) {
		FPMW = fPMW;
	}
	@XmlTransient
	public String getJYM() {
		return JYM;
	}
	public void setJYM(String jYM) {
		JYM = jYM;
	}
	@XmlTransient
	public String getEWM() {
		return EWM;
	}
	public void setEWM(String eWM) {
		EWM = eWM;
	}
	@XmlTransient
	public String getJQBH() {
		return JQBH;
	}
	public void setJQBH(String jQBH) {
		JQBH = jQBH;
	}
	@XmlTransient
	public String getPDF() {
		return PDF;
	}
	public void setPDF(String pDF) {
		PDF = pDF;
	}
	@Override
	public String toString() {
		return "FPKJXX_FPTXX [NSRSBH=" + NSRSBH + ", FJH=" + FJH + ", NSRMC=" + NSRMC + ", XHF_DZ=" + XHF_DZ
				+ ", XHF_DH=" + XHF_DH + ", XHF_YHZH=" + XHF_YHZH + ", GHFMC=" + GHFMC + ", GHF_NSRSBH=" + GHF_NSRSBH
				+ ", GHF_DZ=" + GHF_DZ + ", GHF_GDDH=" + GHF_GDDH + ", GHF_YHZH=" + GHF_YHZH + ", KPY=" + KPY + ", SKY="
				+ SKY + ", FHR=" + FHR + ", KPLX=" + KPLX + ", YFP_DM=" + YFP_DM + ", YFP_HM=" + YFP_HM + ", KPHJJE="
				+ KPHJJE + ", HJBHSJE=" + HJBHSJE + ", HJSE=" + HJSE + ", BZ=" + BZ + ", BB=" + BB + ", WB=" + WB
				+ ", FPZL=" + FPZL + ", KPRQ=" + KPRQ + ", FP_DM=" + FP_DM + ", FP_HM=" + FP_HM + ", FPMW=" + FPMW
				+ ", JYM=" + JYM + ", EWM=" + EWM + ", JQBH=" + JQBH + ", PDF=" + PDF + "]";
	}
	
}
