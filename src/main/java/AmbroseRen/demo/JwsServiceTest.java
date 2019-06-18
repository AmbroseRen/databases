package AmbroseRen.demo;
import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import AmbroseRen.demo.impl.JwsServiceHello;
import AmbroseRen.demo.impl.JwsServiceHelloService;

public class JwsServiceTest {
	
	@Resource
	private AmbroseRen.demo.impl.JwsServiceHelloServiceLocator JwsServiceHelloServiceLocator;
	
	public static void main(String[] args) throws ServiceException {
		
		JwsServiceHello Hello = new AmbroseRen.demo.impl.JwsServiceHelloServiceLocator().getJwsServiceHelloPort();
		try {
			Hello.getValue("SB");
			System.out.println(Hello.getValue(null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
