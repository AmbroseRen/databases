package AmbroseRen.network.CS;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import AmbroseRen.network.CS.HttpContext;
import AmbroseRen.network.CS.ServerContext;

public class HttpResponse {
	private OutputStream out;
	private int status;
	private String contentType;
	private int contentLength;
	private boolean hasPrintHeader;
	private Map<Integer,String> statusMap;
	
	public HttpResponse(OutputStream out) {
		this.out=out;
		statusMap =new HashMap<Integer,String>();
		statusMap.put(HttpContext.STATUS_CODE_OK,HttpContext.STATUS_VALUE_OK);
		statusMap.put(HttpContext.STATUS_CODE_ERROR,HttpContext.STAUTS_VALUE_ERROR);
		statusMap.put(HttpContext.STATUS_CODE_NOT_FOUND,HttpContext.STATUS_VALUE_NOT_FOUND);
	}
	public OutputStream getOutputStream(){
		if(!hasPrintHeader){
			println(ServerContext.protocol+""+status+""+statusMap.get(status));
			println("ContentType:"+contentType);
			println("ContentLength;"+contentLength);
			println("");
		}
		return out;
	}
	private void println(String string) {
		// TODO Auto-generated method stub
		
	}
	public OutputStream getOut() {
		return out;
	}
	public void setOut(OutputStream out) {
		this.out = out;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	public boolean isHasPrintHeader() {
		return hasPrintHeader;
	}
	public void setHasPrintHeader(boolean hasPrintHeader) {
		this.hasPrintHeader = hasPrintHeader;
	}
	public Map<Integer, String> getStatusMap() {
		return statusMap;
	}
	public void setStatusMap(Map<Integer, String> statusMap) {
		this.statusMap = statusMap;
	}
	
}
