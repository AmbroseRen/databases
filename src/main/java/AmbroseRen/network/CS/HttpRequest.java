package AmbroseRen.network.CS;

import java.io.InputStream;

import AmbroseRen.network.CS.HttpContext;

public class HttpRequest {
	private String method;
	private String url;
	private String protocol;
	
	public HttpRequest(InputStream in) throws Exception {
		try {
			String line =readLine(in);
			if(line.length()>0){
				String[] date =line.split("\\s");
				method =date[0];
				url =date[1];
				protocol =date[2];
			}
		} catch (Exception e) {
			throw e;
		}
	}		
	private String readLine(InputStream in) throws Exception{
		StringBuilder builder =new StringBuilder();
		try {
			int ch1=-1,ch2=-1;
			while((ch2=in.read())!=-1){
				if(ch1==HttpContext.CR&&ch2==HttpContext.LF){
					break;					
				}
				builder.append((char)ch2);
				ch1=ch2;
			}
			return builder.toString().trim();
		} catch (Exception e) {
			throw e;
		}
	}
	public String getMethod(){
		return method;
	}
	public String getUrl(){
		return url;
	}
	public String getProtocol(){
		return protocol;
	}
}
