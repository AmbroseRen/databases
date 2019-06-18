package AmbroseRen.demo;

import AmbroseRen.util.Base64Util;
import AmbroseRen.util.Tools;

public class pac5 {
	public static void main(String[] args) throws Exception {
//		Tools.load("http://192.168.10.89:8080/eoffice-restful/resources/sys/oaholiday", 
//				"floor=first&year=2017&month=9&isLeader=N");
		String abc ="abcd1234";
		String bString = Base64Util.getBase64(abc);
		System.out.println(bString);
		System.out.println("====");
		String data="";
		String key ="I7GBo4w9E6dmGlLVJMaVtXrhbNqp4KBh";
		String keys =Tools.hamcsha(bString.getBytes(), key.getBytes());
		System.out.println(keys);
	}
}
