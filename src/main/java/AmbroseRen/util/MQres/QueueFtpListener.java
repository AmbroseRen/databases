package AmbroseRen.util.MQres;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import AmbroseRen.util.MQres.StartTaskThread;
import AmbroseRen.annotation.XmlNode;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import net.sf.json.JSONObject;

public class QueueFtpListener implements MessageListener{
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
    public void onMessage(Message message) {
    	TextMessage  tx = (TextMessage ) message;
        try {
        	JSONObject json=JSONObject.fromObject(tx.getText());
        	Map<String, Class> map = new HashMap<String,Class>();  
            map.put("fpmxs", FpxxMx.class); // key为teacher私有变量的属性名  
            map.put("cusInfo", CusInfo.class); // key为teacher私有变量的属性名  
            // 使用JSONObject.toBean(jsonObject, beanClass, classMap)  
            Fpxx fp = (Fpxx) JSONObject.toBean(json, Fpxx.class, map);  
//        	threadPoolTaskExecutor.execute(new StartTaskThread(fp,fpxxService));
	        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}

/*FpxxMx类*/
class FpxxMx implements Serializable{

	private String f_id;
	private String m_id;
	@XmlNode(reqFiled = "spbm", isNUll=true)
	private String spbm;
	@XmlNode(reqFiled = "spmc", isNUll=true)
	private String spmc;
	@XmlNode(reqFiled = "ggxh")
	private String ggxh;
	@XmlNode(reqFiled = "dw")
	private String dw;
	@XmlNode(reqFiled = "hsbz", isNUll=true)
	private String hsbz;
	@XmlNode(reqFiled = "sl", isNUll=true)
	private Double sl;
	private Double dj;
	@XmlNode(reqFiled = "je", isNUll=true)
	private Double je;
	@XmlNode(reqFiled = "slv", isNUll=true)
	private String slv;
	@XmlNode(reqFiled = "se", isNUll=true)
	private Double se;
	@XmlNode(reqFiled = "zkhbz", isNUll=true)
	private Integer zkhbz;
	@XmlNode(reqFiled = "zklx", isNUll=true)
	private Integer zklx;
	@XmlNode(reqFiled = "lslbs")
	private Integer lslbs;
	@XmlNode(reqFiled = "yhzcbs", isNUll=true)
	private String yhzcbs;
	@XmlNode(reqFiled = "zzstsgl")
	private String zzstsgl;
	@XmlNode(reqFiled = "kce")
	private Integer kce;
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getSpbm() {
		return spbm;
	}
	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getHsbz() {
		return hsbz;
	}
	public void setHsbz(String hsbz) {
		this.hsbz = hsbz;
	}
	public Double getSl() {
		return sl;
	}
	public void setSl(Double sl) {
		this.sl = sl;
	}
	public Double getDj() {
		return dj;
	}
	public void setDj(Double dj) {
		this.dj = dj;
	}
	public Double getJe() {
		return je;
	}
	public void setJe(Double je) {
		this.je = je;
	}
	public String getSlv() {
		return slv;
	}
	public void setSlv(String slv) {
		this.slv = slv;
	}
	public Double getSe() {
		return se;
	}
	public void setSe(Double se) {
		this.se = se;
	}
	public Integer getZkhbz() {
		return zkhbz;
	}
	public void setZkhbz(Integer zkhbz) {
		this.zkhbz = zkhbz;
	}
	public Integer getZklx() {
		return zklx;
	}
	public void setZklx(Integer zklx) {
		this.zklx = zklx;
	}
	public Integer getLslbs() {
		return lslbs;
	}
	public void setLslbs(Integer lslbs) {
		this.lslbs = lslbs;
	}
	public String getYhzcbs() {
		return yhzcbs;
	}
	public void setYhzcbs(String yhzcbs) {
		this.yhzcbs = yhzcbs;
	}
	public String getZzstsgl() {
		return zzstsgl;
	}
	public void setZzstsgl(String zzstsgl) {
		this.zzstsgl = zzstsgl;
	}
	public Integer getKce() {
		return kce;
	}
	public void setKce(Integer kce) {
		this.kce = kce;
	}
	
}

/*CusInfo类*/
class CusInfo implements Serializable {
	private String  u_id;
	private Integer valid;
	private String  cpath;
	private String  l_name;
	private Integer ws_mark;
	private String  ws_name;
	private String  ws_pwd;
	private String  i_terminalcode;
	private String  i_appid;
	private String  i_version;
	private String  i_username;
	private String  i_password;
	private String  i_requestcode;
	private String  i_taxpayerid;
	private String  i_authorizationcode;
	private String  i_responsecode;
	private String  i_zipcode;
	private String  i_encryptcode;
	private String  i_codetype;
	private String  in_dsptbm;
	private String  in_nsrsbh;
	private String  in_nsrmc;
	private String  in_dkbz;
	private String  ca_public_trusts;
	private String  ca_client_decryptcer;
	private String  ca_client_decryptpfx;
	private String  ca_client_decryptpfx_key;
	private String  ca_platform_decryptcer;
	private String  ca_platform_decryptpfx;
	private String  ca_platform_decryptpfx_key;
	private Integer istest;
	private String  czyname;
	private String  kpfwqdz;
	@XmlNode(reqFiled = "wspwd", resFiled = "",isNUll=true)
	private String  l_pwd;
	@XmlNode(reqFiled = "wsname", resFiled = "",isNUll=true)
	private String username;
	@XmlNode(reqFiled = "wspwd", resFiled = "",isNUll=true)
	private String cpwd;
	@XmlNode(reqFiled = "callbackurl", resFiled = "")
	private String callbackurl;
	
	
	public String getCallbackurl() {
		return callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getCpath() {
		return cpath;
	}
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public Integer getWs_mark() {
		return ws_mark;
	}
	public void setWs_mark(Integer ws_mark) {
		this.ws_mark = ws_mark;
	}
	public String getWs_name() {
		return ws_name;
	}
	public void setWs_name(String ws_name) {
		this.ws_name = ws_name;
	}
	public String getWs_pwd() {
		return ws_pwd;
	}
	public void setWs_pwd(String ws_pwd) {
		this.ws_pwd = ws_pwd;
	}
	public String getI_terminalcode() {
		return i_terminalcode;
	}
	public void setI_terminalcode(String i_terminalcode) {
		this.i_terminalcode = i_terminalcode;
	}
	public String getI_appid() {
		return i_appid;
	}
	public void setI_appid(String i_appid) {
		this.i_appid = i_appid;
	}
	public String getI_version() {
		return i_version;
	}
	public void setI_version(String i_version) {
		this.i_version = i_version;
	}
	public String getI_username() {
		return i_username;
	}
	public void setI_username(String i_username) {
		this.i_username = i_username;
	}
	public String getI_password() {
		return i_password;
	}
	public void setI_password(String i_password) {
		this.i_password = i_password;
	}
	public String getI_requestcode() {
		return i_requestcode;
	}
	public void setI_requestcode(String i_requestcode) {
		this.i_requestcode = i_requestcode;
	}
	public String getI_taxpayerid() {
		return i_taxpayerid;
	}
	public void setI_taxpayerid(String i_taxpayerid) {
		this.i_taxpayerid = i_taxpayerid;
	}
	public String getI_authorizationcode() {
		return i_authorizationcode;
	}
	public void setI_authorizationcode(String i_authorizationcode) {
		this.i_authorizationcode = i_authorizationcode;
	}
	public String getI_responsecode() {
		return i_responsecode;
	}
	public void setI_responsecode(String i_responsecode) {
		this.i_responsecode = i_responsecode;
	}
	public String getI_zipcode() {
		return i_zipcode;
	}
	public void setI_zipcode(String i_zipcode) {
		this.i_zipcode = i_zipcode;
	}
	public String getI_encryptcode() {
		return i_encryptcode;
	}
	public void setI_encryptcode(String i_encryptcode) {
		this.i_encryptcode = i_encryptcode;
	}
	public String getI_codetype() {
		return i_codetype;
	}
	public void setI_codetype(String i_codetype) {
		this.i_codetype = i_codetype;
	}
	public String getIn_dsptbm() {
		return in_dsptbm;
	}
	public void setIn_dsptbm(String in_dsptbm) {
		this.in_dsptbm = in_dsptbm;
	}
	public String getIn_nsrsbh() {
		return in_nsrsbh;
	}
	public void setIn_nsrsbh(String in_nsrsbh) {
		this.in_nsrsbh = in_nsrsbh;
	}
	public String getIn_nsrmc() {
		return in_nsrmc;
	}
	public void setIn_nsrmc(String in_nsrmc) {
		this.in_nsrmc = in_nsrmc;
	}
	public String getIn_dkbz() {
		return in_dkbz;
	}
	public void setIn_dkbz(String in_dkbz) {
		this.in_dkbz = in_dkbz;
	}
	public String getCa_public_trusts() {
		return ca_public_trusts;
	}
	public void setCa_public_trusts(String ca_public_trusts) {
		this.ca_public_trusts = ca_public_trusts;
	}
	public String getCa_client_decryptcer() {
		return ca_client_decryptcer;
	}
	public void setCa_client_decryptcer(String ca_client_decryptcer) {
		this.ca_client_decryptcer = ca_client_decryptcer;
	}
	public String getCa_client_decryptpfx() {
		return ca_client_decryptpfx;
	}
	public void setCa_client_decryptpfx(String ca_client_decryptpfx) {
		this.ca_client_decryptpfx = ca_client_decryptpfx;
	}
	public String getCa_client_decryptpfx_key() {
		return ca_client_decryptpfx_key;
	}
	public void setCa_client_decryptpfx_key(String ca_client_decryptpfx_key) {
		this.ca_client_decryptpfx_key = ca_client_decryptpfx_key;
	}
	public String getCa_platform_decryptcer() {
		return ca_platform_decryptcer;
	}
	public void setCa_platform_decryptcer(String ca_platform_decryptcer) {
		this.ca_platform_decryptcer = ca_platform_decryptcer;
	}
	public String getCa_platform_decryptpfx() {
		return ca_platform_decryptpfx;
	}
	public void setCa_platform_decryptpfx(String ca_platform_decryptpfx) {
		this.ca_platform_decryptpfx = ca_platform_decryptpfx;
	}
	public String getCa_platform_decryptpfx_key() {
		return ca_platform_decryptpfx_key;
	}
	public void setCa_platform_decryptpfx_key(String ca_platform_decryptpfx_key) {
		this.ca_platform_decryptpfx_key = ca_platform_decryptpfx_key;
	}
	public Integer getIstest() {
		return istest;
	}
	public void setIstest(Integer istest) {
		this.istest = istest;
	}
	public String getCzyname() {
		return czyname;
	}
	public void setCzyname(String czyname) {
		this.czyname = czyname;
	}
	public String getKpfwqdz() {
		return kpfwqdz;
	}
	public void setKpfwqdz(String kpfwqdz) {
		this.kpfwqdz = kpfwqdz;
	}
	public String getL_pwd() {
		return l_pwd;
	}
	public void setL_pwd(String l_pwd) {
		this.l_pwd = l_pwd;
	}
	
	
}

/*Fpxx类*/
class Fpxx implements Serializable {
	private CusInfo cusInfo;
	private List<FpxxMx> fpmxs;
	private String  f_id;
	private String  u_id;
	private String  fplsh;
	private Date    cjsj;
	private Integer yxbz;
	@XmlNode(reqFiled = "fpzl", isNUll=true)
	private Integer fpzl_id;
	private String  fpzl;
	@XmlNode(reqFiled = "fplx", isNUll=true)
	private Integer fplx_id;
	private String  fplx;
	@XmlNode(reqFiled = "fpzf", isNUll=true)
	private Integer fpzf_id;
	private String  fpzf;
	private String  fpdm;
	private String  fphm;
	private Date   fpsj;
	private Integer zfbz;
	private Integer hcbz;
	private Integer scztbz;
	private Integer scbz;
	private String  sczt;
	private Integer xzztbz;
	private Integer xzbz;
	private String  xzzt;
	private String  fpwldz;
	private String  fpbddz;
	@XmlNode(reqFiled = "xfmc", isNUll=true)
	private String  xfmc;
	
	@XmlNode(reqFiled = "xfsh", isNUll=true)
	private String  xfsh;
	
	@XmlNode(reqFiled = "xfkpjh", resFiled = "")
	private String  xfkpjh;
	
	@XmlNode(reqFiled = "xfdz", isNUll=true)
	private String  xfdz;
	
	@XmlNode(reqFiled = "xfdh", isNUll=true)
	private String  xfdh;
	
	@XmlNode(reqFiled = "xfyhzh", resFiled = "")
	private String  xfyhzh;
	
	@XmlNode(reqFiled = "gflx", isNUll=true)
	private String  gflx_id;
	
	private String  gflx;
	@XmlNode(reqFiled = "gfmc", isNUll=true)
	private String  gfmc;
	@XmlNode(reqFiled = "gfsh", resFiled = "")
	private String  gfsh;
	@XmlNode(reqFiled = "gfdz", resFiled = "")
	private String  gfdz;
	private String  gfsf;
	@XmlNode(reqFiled = "gfdh", isNUll=true)
	private String  gfdh;
	@XmlNode(reqFiled = "gfsj", resFiled = "")
	private String  gfsj;
	@XmlNode(reqFiled = "gfyhzh", resFiled = "")
	private String  gfyhzh;
	@XmlNode(reqFiled = "gfyx", resFiled = "")
	private String  gfyx;
	@XmlNode(reqFiled = "kpr", isNUll=true)
	private String  kpr;
	@XmlNode(reqFiled = "skr", resFiled = "")
	private String  skr;
	@XmlNode(reqFiled = "fhr", resFiled = "")
	private String  fhr;
	@XmlNode(reqFiled = "bz", resFiled = "")
	private String  bz;
	private Integer hcfpid;
	@XmlNode(reqFiled = "hcfpdm", resFiled = "")
	private String  hcfpdm;
	@XmlNode(reqFiled = "hcfphm", resFiled = "")
	private String  hcfphm;
	@XmlNode(reqFiled = "hztzdh", resFiled = "")
	private String  hztzdh;
	@XmlNode(reqFiled = "djbh", isNUll=true)
	private String  djbh;
	private Integer istest;
	private String  fwmw;
	private String  jym;
	private String  fjh;
	private String  jqbh;
	private String  ewm;
	private String  callbackurl;
	private String  msgcode;
	private String  msginfo;
	private Integer fpzt;
	private Double jshjje;
	private Double hjje;
	private Double hjse;
	private Integer smcs;
	private String username;
	
	
	CusInfo getCusInfo() {
		return cusInfo;
	}
	public void setCusInfo(CusInfo cusInfo) {
		this.cusInfo = cusInfo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<FpxxMx> getFpmxs() {
		return fpmxs;
	}
	public void setFpmxs(List<FpxxMx> fpmxs) {
		this.fpmxs = fpmxs;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getFplsh() {
		return fplsh;
	}
	public void setFplsh(String fplsh) {
		this.fplsh = fplsh;
	}
	public Date getCjsj() {
		return cjsj;
	}
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	public Integer getYxbz() {
		return yxbz;
	}
	public void setYxbz(Integer yxbz) {
		this.yxbz = yxbz;
	}
	public Integer getFpzl_id() {
		return fpzl_id;
	}
	public void setFpzl_id(Integer fpzl_id) {
		this.fpzl_id = fpzl_id;
	}
	public String getFpzl() {
		return fpzl;
	}
	public void setFpzl(String fpzl) {
		this.fpzl = fpzl;
	}
	public Integer getFplx_id() {
		return fplx_id;
	}
	public void setFplx_id(Integer fplx_id) {
		this.fplx_id = fplx_id;
	}
	public String getFplx() {
		return fplx;
	}
	public void setFplx(String fplx) {
		this.fplx = fplx;
	}
	public Integer getFpzf_id() {
		return fpzf_id;
	}
	
	public void setFpzf_id(Integer fpzf_id) {
		this.fpzf_id = fpzf_id;
	}
	public String getFpzf() {
		return fpzf;
	}
	public void setFpzf(String fpzf) {
		this.fpzf = fpzf;
	}
	public String getFpdm() {
		return fpdm;
	}
	public void setFpdm(String fpdm) {
		this.fpdm = fpdm;
	}
	public String getFphm() {
		return fphm;
	}
	public void setFphm(String fphm) {
		this.fphm = fphm;
	}
	public Date getFpsj() {
		return fpsj;
	}
	public void setFpsj(Date fpsj) {
		this.fpsj = fpsj;
	}
	public Integer getZfbz() {
		return zfbz;
	}
	public void setZfbz(Integer zfbz) {
		this.zfbz = zfbz;
	}
	public Integer getHcbz() {
		return hcbz;
	}
	public void setHcbz(Integer hcbz) {
		this.hcbz = hcbz;
	}
	public Integer getScztbz() {
		return scztbz;
	}
	public void setScztbz(Integer scztbz) {
		this.scztbz = scztbz;
	}
	public Integer getScbz() {
		return scbz;
	}
	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}
	public String getSczt() {
		return sczt;
	}
	public void setSczt(String sczt) {
		this.sczt = sczt;
	}
	public Integer getXzztbz() {
		return xzztbz;
	}
	public void setXzztbz(Integer xzztbz) {
		this.xzztbz = xzztbz;
	}
	public Integer getXzbz() {
		return xzbz;
	}
	public void setXzbz(Integer xzbz) {
		this.xzbz = xzbz;
	}
	public String getXzzt() {
		return xzzt;
	}
	public void setXzzt(String xzzt) {
		this.xzzt = xzzt;
	}
	public String getFpwldz() {
		return fpwldz;
	}
	public void setFpwldz(String fpwldz) {
		this.fpwldz = fpwldz;
	}
	public String getFpbddz() {
		return fpbddz;
	}
	public void setFpbddz(String fpbddz) {
		this.fpbddz = fpbddz;
	}
	public String getXfmc() {
		return xfmc;
	}
	public void setXfmc(String xfmc) {
		this.xfmc = xfmc;
	}
	public String getXfsh() {
		return xfsh;
	}
	public void setXfsh(String xfsh) {
		this.xfsh = xfsh;
	}
	public String getXfkpjh() {
		return xfkpjh;
	}
	public void setXfkpjh(String xfkpjh) {
		this.xfkpjh = xfkpjh;
	}
	public String getXfdz() {
		return xfdz;
	}
	public void setXfdz(String xfdz) {
		this.xfdz = xfdz;
	}
	public String getXfdh() {
		return xfdh;
	}
	public void setXfdh(String xfdh) {
		this.xfdh = xfdh;
	}
	public String getXfyhzh() {
		return xfyhzh;
	}
	public void setXfyhzh(String xfyhzh) {
		this.xfyhzh = xfyhzh;
	}
	public String getGflx_id() {
		return gflx_id;
	}
	public void setGflx_id(String gflx_id) {
		this.gflx_id = gflx_id;
	}
	public String getGflx() {
		return gflx;
	}
	public void setGflx(String gflx) {
		this.gflx = gflx;
	}
	public String getGfmc() {
		return gfmc;
	}
	public void setGfmc(String gfmc) {
		this.gfmc = gfmc;
	}
	public String getGfsh() {
		return gfsh;
	}
	public void setGfsh(String gfsh) {
		this.gfsh = gfsh;
	}
	public String getGfdz() {
		return gfdz;
	}
	public void setGfdz(String gfdz) {
		this.gfdz = gfdz;
	}
	public String getGfsf() {
		return gfsf;
	}
	public void setGfsf(String gfsf) {
		this.gfsf = gfsf;
	}
	public String getGfdh() {
		return gfdh;
	}
	public void setGfdh(String gfdh) {
		this.gfdh = gfdh;
	}
	public String getGfsj() {
		return gfsj;
	}
	public void setGfsj(String gfsj) {
		this.gfsj = gfsj;
	}
	public String getGfyhzh() {
		return gfyhzh;
	}
	public void setGfyhzh(String gfyhzh) {
		this.gfyhzh = gfyhzh;
	}
	public String getGfyx() {
		return gfyx;
	}
	public void setGfyx(String gfyx) {
		this.gfyx = gfyx;
	}
	public String getKpr() {
		return kpr;
	}
	public void setKpr(String kpr) {
		this.kpr = kpr;
	}
	public String getSkr() {
		return skr;
	}
	public void setSkr(String skr) {
		this.skr = skr;
	}
	public String getFhr() {
		return fhr;
	}
	public void setFhr(String fhr) {
		this.fhr = fhr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Integer getHcfpid() {
		return hcfpid;
	}
	public void setHcfpid(Integer hcfpid) {
		this.hcfpid = hcfpid;
	}
	public String getHcfpdm() {
		return hcfpdm;
	}
	public void setHcfpdm(String hcfpdm) {
		this.hcfpdm = hcfpdm;
	}
	public String getHcfphm() {
		return hcfphm;
	}
	public void setHcfphm(String hcfphm) {
		this.hcfphm = hcfphm;
	}
	public String getHztzdh() {
		return hztzdh;
	}
	public void setHztzdh(String hztzdh) {
		this.hztzdh = hztzdh;
	}
	public String getDjbh() {
		return djbh;
	}
	public void setDjbh(String djbh) {
		this.djbh = djbh;
	}
	public Integer getIstest() {
		return istest;
	}
	public void setIstest(Integer istest) {
		this.istest = istest;
	}
	public String getFwmw() {
		return fwmw;
	}
	public void setFwmw(String fwmw) {
		this.fwmw = fwmw;
	}
	public String getJym() {
		return jym;
	}
	public void setJym(String jym) {
		this.jym = jym;
	}
	public String getFjh() {
		return fjh;
	}
	public void setFjh(String fjh) {
		this.fjh = fjh;
	}
	public String getJqbh() {
		return jqbh;
	}
	public void setJqbh(String jqbh) {
		this.jqbh = jqbh;
	}
	public String getEwm() {
		return ewm;
	}
	public void setEwm(String ewm) {
		this.ewm = ewm;
	}
	public String getCallbackurl() {
		return callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}
	public String getMsgcode() {
		return msgcode;
	}
	public void setMsgcode(String msgcode) {
		this.msgcode = msgcode;
	}
	public String getMsginfo() {
		return msginfo;
	}
	public void setMsginfo(String msginfo) {
		this.msginfo = msginfo;
	}
	public Integer getFpzt() {
		return fpzt;
	}
	public void setFpzt(Integer fpzt) {
		this.fpzt = fpzt;
	}
	public Double getJshjje() {
		return jshjje;
	}
	public void setJshjje(Double jshjje) {
		this.jshjje = jshjje;
	}
	public Double getHjje() {
		return hjje;
	}
	public void setHjje(Double hjje) {
		this.hjje = hjje;
	}
	public Double getHjse() {
		return hjse;
	}
	public void setHjse(Double hjse) {
		this.hjse = hjse;
	}
	public Integer getSmcs() {
		return smcs;
	}
	public void setSmcs(Integer smcs) {
		this.smcs = smcs;
	}
}
