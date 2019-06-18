package AmbroseRen.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;

public class Coding extends HttpServlet{

	private static final long serialVersionUID = -3888381930670471753L;

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str ="汉字编码测试";
		String str2 =URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
		String str3 =URLDecoder.decode(str2,"utf-8");
		System.out.println(str3);
	}
	
}
