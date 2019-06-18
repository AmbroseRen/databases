package AmbroseRen.kit.Xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import oracle.net.aso.e;

/**
 * 使用XPath检索文档数据
 * 
 *若在DOM4J中希望使用XPath检索数据，需要额外的
 *再引入一个jar文件：jaxen-x.x.x.jar
 */
public class XPath {
	public static void main(String[] args) {
		try {
			SAXReader sr =new SAXReader();
			Document doc =sr.read(new FileInputStream("Nbill.xml"));
			
			String path = "/interface/Data/content";
			List<Element> list = doc.selectNodes(path);
			
			for (Element e : list) {
				System.out.println(e.getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//XmlEle("Nbill.xml","/interface/Data/content");
		
	}
	/**
	 * 
	 * @param FileURL	"Nbill.xml"
	 * @param EleURL	"/interface/Data/content"
	 * @return
	 */
	public static List<Element> XmlEle(String FileURL,String ElePath){
		SAXReader sr =new SAXReader();
		Document doc;
		List<Element> list = null;
		try {
				doc = sr.read(new FileInputStream(FileURL));
			list = doc.selectNodes(ElePath);
			
			for (Element e : list) {
				System.out.println(e.getText());
		}
		} catch (FileNotFoundException | DocumentException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
}







