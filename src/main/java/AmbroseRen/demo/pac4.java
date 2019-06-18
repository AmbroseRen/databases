package AmbroseRen.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import AmbroseRen.util.Base64Util;
import AmbroseRen.util.Tools;

public class pac4 {
	public static void main(String[] args) {
		request("https://www.baidu.com", "");
	}

	public static Map<String, Object> request(String url, String content) {
		 Map<String, Object> result = new HashMap<String, Object>(); 
		 String errorStr ="";
		 String status ="";
		 String response ="";
		 PrintWriter out =null;
		 BufferedReader in =null;
		 try {
			 URL realUrl = new URL(url);  
			 URLConnection con =realUrl.openConnection();
			 HttpURLConnection httpURLConnection =(HttpURLConnection)con;
			 httpURLConnection.setRequestProperty("Content-Type", "application/json");
			 httpURLConnection.setRequestProperty("x-adviewrtb-version", "2.1");
			 httpURLConnection.setDoOutput(true);
			 httpURLConnection.setDoInput(true);
			 out =new PrintWriter(httpURLConnection.getOutputStream());
			 out.write(content);
			 out.flush();
			 httpURLConnection.connect();
			 in =new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			 String line;
			 while ((line =in.readLine()) !=null) {
				response+=line;
			}
			 status = new Integer(httpURLConnection.getResponseCode()).toString();
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);  
			errorStr = e.getMessage();  
		}
        result.put("errorStr", errorStr);  
        result.put("response", response);  
        result.put("status", status);  
		return result;  
		
	}
	
}
