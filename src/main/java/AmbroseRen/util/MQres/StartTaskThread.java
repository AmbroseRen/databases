package AmbroseRen.util.MQres;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import AmbroseRen.util.Base64Util;
import AmbroseRen.util.MQres.PKCS7;
import AmbroseRen.util.activeMQ.MQProducer;
import net.sf.json.JSONObject;
import AmbroseRen.util.MQres.EnumConstant;

public class StartTaskThread implements Runnable{
    private AmbroseRen.util.MQres.Fpxx fpxx;
//    private FpxxServiceI fpxxService;

	@Override
	   public synchronized void run() {
		   try {
			   ftps();
		   } catch (Exception e) {
			   System.out.println("推送异常信息："+e.getMessage());
			   e.printStackTrace();
		   }
	   }

	private void ftps() throws UnsupportedEncodingException {
		CusInfo cusinfo=fpxx.getCusInfo();
		String uploadInnerXml=geneMailConXml();
		byte[] dat = read(cusinfo.getCa_public_trusts());
		String strTrusts = new String(dat);
		//读取公钥
		dat = read(cusinfo.getCa_platform_decryptcer());
		String strEncCert = new String(dat);
		//读取私钥
		byte[] bszSignPfx =  read(cusinfo.getCa_client_decryptpfx());
		String strSignCertPfxPwd = cusinfo.getCa_client_decryptpfx_key();
		
		final byte[] encodeUploadData = PKCS7.signedAndEnvelopedMulti(strTrusts,strEncCert,bszSignPfx,strSignCertPfxPwd,uploadInnerXml.getBytes("UTF-8"));
		String encodeUploadText = new String(Base64.encodeBase64(encodeUploadData));
		StringBuffer sx=new StringBuffer();
		geneWcXml(sx,encodeUploadText,EnumConstant.INTERFACECODE_EILNTERFACEEMAIL.getName());
		String rs=reqService(sx.toString(),EnumConstant.QZ_URL.getName(),EnumConstant.QZ_FUN.getName());
		getResult(rs);
		if(fpxx.getMsgcode().equals("0000")){
			 System.out.println("推送成功！");
			fpxx.setFpzt(EnumConstant.FPZT_YTS);
			updateFpxx(fpxx);
		}else{
			System.out.println("推送失败！");
			updateFpxx(fpxx);
		}
		
	}
	
	public static void updateFpxx(Fpxx fpxx) {
//		basedao.getMap("updateFpxx", fpxx);//sql更新处理，返回Map
		
		JSONObject json=JSONObject.fromObject(fpxx);
		String jxs=json.toString();
		if(!StringUtils.isBlank(fpxx.getCallbackurl())){
			MQProducer.sendMessage("fphdQueue",jxs);
		}
	}
	
	private void geneWcXml(StringBuffer sx,String contentxml,String interfaceCode){
		CusInfo cusinfo=fpxx.getCusInfo();
		sx.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		appenStr("<interface xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd\" version=\"DZFP1.0\">",sx, 0);
		appenStr("<globalInfo>",sx,0);
		appenStr("</Data>",sx,0);
		sx.append("\n</interface>");
	}
	
   private String  geneMailConXml(){
		StringBuffer s=new StringBuffer();
		appenStr("<REQUEST_EMAILPHONEFPTS class=\"REQUEST_EMAILPHONEFPTS\">",s,0);
		appenStr("</REQUEST_EMAILPHONEFPTS>",s,0);
		System.out.println(s.toString());
		return s.toString();
   }	

	//util方法
	private  byte[] read(String file) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			byte buf[] = new byte[in.available()];
			in.read(buf, 0, buf.length);
			in.close();
			return buf;
		} catch (IOException e) {
			return null;
		}
	}
	private void appenStr(String appstr,StringBuffer sb,int kg){
		sb.append("\n    ");
		for(int i=0;i<kg;i++){
			sb.append("    ");
		}
		sb.append(appstr);
	}
	private String reqService(String param,String url,String  methodx){
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
	    // String wsUrl = "http://qzfw.51fapiao.cn:20080/fpqz/webservice/eInvWS?wsdl"; 
	    Client client = null;//dcf.createClient(url);
	    String method =methodx;//webservice的方法名 
	    Object[] result = null;
	    try {
	       result = client.invoke(method,param);//调用webservice 
	      // System.out.println(result[0]);
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
		return result[0].toString();
	}
	private void getResult(String xmlString) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlString);
			Element rootElt = doc.getRootElement();
			Iterator<?> returnStateInfo = rootElt.elementIterator("returnStateInfo");
			while (returnStateInfo.hasNext()) {
				Element returnStateInfoElt = (Element) returnStateInfo.next();
				fpxx.setMsgcode(returnStateInfoElt.elementTextTrim("returnCode"));
				fpxx.setMsginfo(Base64Util.getFromBase64(returnStateInfoElt.elementTextTrim("returnMessage")));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
	
}
