package AmbroseRen.demo2;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import AmbroseRen.util.Tools;

public class pac1 {
	public static void main(String[] args) throws Exception {
		String s1 =" GROUP BY DATENAME(MONTH,create_date)";
		System.out.println(s1.substring(19,24));
		
		String s2=" GROUP BY DATENAME(  DAY,create_date)";
		System.out.println(s2.substring(19,24));
		
		String b1 ="3";
		System.out.println(Integer.parseInt(b1)>2);
	}
	
}
