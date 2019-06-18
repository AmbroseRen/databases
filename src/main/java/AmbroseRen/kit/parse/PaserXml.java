package AmbroseRen.kit.parse;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import AmbroseRen.util.Base64Util;


public class PaserXml {
	
	public static void main(String[] args) throws JAXBException {
//		    File file = new File("param.xml");
//	        JAXBContext jaxbContext = JAXBContext.newInstance(XmlConfig.class);
//	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//	        XmlConfig info = (XmlConfig) jaxbUnmarshaller.unmarshal( file );
//	        System.out.println(info.getData().getContent().getREQUEST_FPKJXX().getFPKJXX_FPTXX().getFJH());
//		String aString =Parse("param.xml");
//		System.out.println("=aString="+aString)
		
//		Date now =new Date();
//		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
//		String str =sdf.format(now);
		XmlConfig all =Parse("bill.xml");
//		all.getGlobalInfo().setInterfaceCode("DZFP_FP_SUBMIT");
//		String cdate =all.getGlobalInfo().setRequestTime(str);
		System.out.println(">>"+all.getGlobalInfo().getInterfaceCode());
		String MD5 =Base64Util.getBase64(all.toString());
		System.out.println(MD5);
	}
	
	public static  XmlConfig Parse(String  fileNameURL) throws JAXBException{
	    File file = new File(fileNameURL);//"param.xml"
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlConfig.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        XmlConfig infos = (XmlConfig) jaxbUnmarshaller.unmarshal( file );
		return infos;
	}
}
