package AmbroseRen.kit;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

/**  
*   
* 项目名称：AmbroseRen  
* 类名称：WSClient  
* 类描述：  WebService接口调用类
* 创建人：AmbroseRen  
* 创建时间：2018年10月16日 上午11:25:52  
* @version       1.0.1
*/ 
public class WSClient {

	public static void main(String[] args) throws AxisFault {
		WSClient("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl",
				"getSupportProvince",
				"http://WebXml.com.cn/");
	}
	
	/**
	 * @param targetEndpoint  WebService接口地址
	 * @param method  方法名
	 * @param targetNamespace  命名空间
	 * @return  XML文档
	 * @throws AxisFault
	 */
	public static OMElement WSClient(String targetEndpoint,String method,String targetNamespace)  
			throws AxisFault{
//		  String targetEndpoint="http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
//		  String method="getSupportProvince";
//		  String targetNamespace="http://WebXml.com.cn/";
		  Options options = new Options();
		  options.setTo(new EndpointReference(targetEndpoint));
		  options.setTimeOutInMilliSeconds(1000 * 60 * 5);
		  options.setAction(targetNamespace+method);
		  ServiceClient sender = new ServiceClient();
      sender.setOptions(options);
      OMFactory fac = OMAbstractFactory.getOMFactory();
      OMNamespace omNs = fac.createOMNamespace(targetNamespace,"");
      OMElement methods = fac.createOMElement(method, omNs);
      OMElement symbol = fac.createOMElement("byProvinceName", omNs);
      symbol.addChild(fac.createOMText(symbol,""));
      methods.addChild(symbol);
      methods.build();
      OMElement result = sender.sendReceive(methods);
      System.out.println(result);
      return result;
	}
	
}
