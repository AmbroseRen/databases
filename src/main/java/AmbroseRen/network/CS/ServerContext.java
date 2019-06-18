package AmbroseRen.network.CS;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServerContext {
	public static int ServerPort;
	public static int max_thread;
	public static String web_root;
	public static String protocol;
	public static Map<String,String> types =new HashMap<String,String>();
	public static String notFoundPage;
	
	static{
		try {
			SAXReader reader =new SAXReader();
			Document doc =reader.read(
					new FileInputStream(
							"config"+File.separator+"server.xml"));
			
			Element root =doc.getRootElement();
			Element serviceEle =root.element("service");
			Element connEle =serviceEle.element("connector");
			
			protocol =connEle.attributeValue("protocol");
			ServerPort =Integer.parseInt(connEle.attributeValue("port"));
			max_thread =Integer.parseInt(connEle.attributeValue("maxThread"));
			web_root =serviceEle.elementText("webroot");
			notFoundPage =serviceEle.elementText("NOT_FOUND_PAGE");
			System.out.println("请求状态完毕！");
			
			/**
			 * 解析<type-mappings>
			 */
			Element mappingsEle =root.element("type-mappings");
//														s的区别
			List<Element> mappingsList =mappingsEle.elements();
			for(Element mappings:mappingsList){
				types.put(mappings.attributeValue("ext"),mappings.attributeValue("type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
