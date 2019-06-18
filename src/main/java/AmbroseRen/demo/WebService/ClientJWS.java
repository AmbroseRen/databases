package AmbroseRen.demo.WebService;

import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
/**
 * @介绍：
 * WebService是一种跨编程语言和跨操作系统平台的远程调用技术。<br/>
 *    所谓跨编程语言和跨操作平台，就是说服务端程序采用java编写，客户端程序则可以采用其他编程语言编写，反之亦然！
 * 跨操作系统平台则是指服务端程序和客户端程序可以在不同的操作系统上运行。<br/>
 *    所谓远程调用，就是一台计算机a上的一个程序可以调用到另外一台计算机b上的一个对象的方法，
 * 譬如，银联提供给商场的pos刷卡系统，商场的POS机转账调用的转账方法的代码其实是跑在银行服务器上。<br/>
 * @步骤：<br/>
 * 1.即时发布<br/>
 *    1> 将Axis部署到Tomcat服务器中；<br/>
 *    2> 编写Java定制服务代码，HelloWebService.jws并改其后缀名为.jws；<br/>
 *    3> jws文件放置目录D:\tomcat6\webapps\axis，并发布Web Service服务；<br/>
 *    4> 编写客户端，并调用Web Service中的远程接口及其方法；<br/>
 */
public class ClientJWS {
	public static void main(String[] args) {
		try {
			//定义字符串，描述要访问的服务器地址 [改为自己需要访问的Web Service服务路径]
			String url = "http://192.168.0.67:8080/Service/ServiceHello?wsdl";
			//创建一个 Web Service的服务
			Service sv = new Service();
			//创建一个调用
			Call call = (Call) sv.createCall();
			//指定服务的来源
			call.setTargetEndpointAddress(url);
			//指明调用的具体方法名
			call.setOperationName(new QName(url, "getValue"));
			//执行远端的调用
			String result = (String) call.invoke(new Object[]{"Student", "Teacher"});
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

