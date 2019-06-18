package AmbroseRen.kit.parseXml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class PaserXml {
	
	public static void main(String[] args) throws JAXBException {
		    File file = new File("CardInfo.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(XmlConfig.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        XmlConfig info = (XmlConfig) jaxbUnmarshaller.unmarshal( file );
	        System.out.println(info.toString());
	}

}
