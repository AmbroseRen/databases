package AmbroseRen.demo;

import javax.xml.bind.JAXBException;

import AmbroseRen.kit.parse.PaserXml;
import AmbroseRen.kit.parse.XmlConfig;
import AmbroseRen.util.AES;
import AmbroseRen.util.Base64Util;
import AmbroseRen.util.Tools;

public class pac3 {
	public static void main(String[] args) throws JAXBException {
		XmlConfig all =PaserXml.Parse("bill.xml");
//		all.getData().setContent();
//		System.out.println(all.getData());
		String RequestParam =Base64Util.getBase64(all.toString());
		System.out.println(RequestParam);
		System.out.println("====");
		
		String key="I7GBo4w9E6dmGlLVJMaVtXrhbNqp4KBh";
		String password ="WuMlCJRN8zO886dw";
		byte[] S =AES.encrypt(all.getData().getContent().toString(), password);
		String Signature =Base64Util.getBase64(S.toString());
		String Sig =Tools.hamcsha(Signature.getBytes(),key.getBytes());
//		String Signature =Tools.hamcsha(RequestParam.getBytes(), key.getBytes());
		System.out.println(Sig);
		try {
			Tools.load("http://test2.51fapiaonb.cn:4011/DZFP_Hyf", 
					"RequestParam="+RequestParam+"&Signature="+Sig+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
