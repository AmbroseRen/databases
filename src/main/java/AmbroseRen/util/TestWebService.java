package AmbroseRen.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import AmbroseRen.util.Base64Util;

public class TestWebService {

	public static void main(String[] args) throws Exception {
		TestWebService t=new TestWebService();
	}
	
	public void test2(String xmlInfo) throws Exception{
		TestWebService t=new TestWebService();
		Client client =new Client(new URL("http://192.168.0.111:8081/dzfpjs/service/invoice?wsdl")); 
		Object[] results=null;
		String xml=xmlInfo;
		xml=Base64Util.getBase64(xml);
		results=client.invoke("invoiceStatus", new Object[]{xml}); 
		System.out.println("添加结果："+results[0]);
	}
	public String test1(String xmlInfo) throws Exception{
		TestWebService t=new TestWebService();
		Client client =new Client(new URL("http://192.168.0.111:8081/dzfpjs/service/invoice?wsdl")); 
		Object[] results=null;
		String xml=xmlInfo;
		xml=Base64Util.getBase64(xml);
		results=client.invoke("invoice", new Object[]{xml}); 
		System.out.println("添加结果："+results[0]);
		String res=(String) results[0];
		return res;
	}
	
	public String getXMlTst(String filename) throws Exception{
        String pathname = "D:/workspace/new/dzfp/"+filename; 
        org.jdom.Document document=null;  
        try {  
            SAXBuilder reader = new SAXBuilder();   
            document=reader.build(new File(pathname));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
          
        Format format =Format.getPrettyFormat();      
        format.setEncoding("UTF-8");//设置编码格式   
          
        StringWriter out=null; //输出对象  
        String sReturn =""; //输出字符串  
        XMLOutputter outputter =new XMLOutputter();   
        out=new StringWriter();   
        try {  
           outputter.output(document,out);  
        } catch (IOException e) {  
           e.printStackTrace();  
        }   
        sReturn=out.toString();   
        return sReturn;  
	}
	
}
