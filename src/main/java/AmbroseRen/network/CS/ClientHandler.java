package AmbroseRen.network.CS;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import AmbroseRen.network.CS.HttpContext;
import AmbroseRen.network.CS.ServerContext;
import AmbroseRen.network.CS.HttpRequest;
import AmbroseRen.network.CS.HttpResponse;

public class ClientHandler {
	private Socket socket;
	public ClientHandler(){
		this.socket=socket;
	}
	public void run(){
		try {
			InputStream in =socket.getInputStream();
			OutputStream out =socket.getOutputStream();
			
			HttpRequest request =new HttpRequest(in);//创建流------
			
			HttpResponse response =new HttpResponse(out);//创建流----- 
			File file =new File(ServerContext.web_root+request.getUrl());
			if(file.exists()){
//				响应状态------------------------------
				response.setStatus(HttpContext.STATUS_CODE_OK);
				response.setContentType(getContentTypeByFile(file));
				response.setContentLength((int)file.length());
				System.out.println("客户端响应完毕！");
			}else{
//				显示错误
				response.setStatus(HttpContext.STATUS_CODE_NOT_FOUND);
				file =new File(ServerContext.web_root+File.separator+
						ServerContext.notFoundPage);
				response.setContentType(getContentTypeByFile(file));
				response.setContentLength((int)file.length());
				responsFile(file,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private String getContentTypeByFile(File file){
		String fileName =file.getName();
		String ext =fileName.substring(fileName.lastIndexOf(".")+1);
		/*--------------*/
		String contentType =ServerContext.types.get(ext);
		System.out.println("contentType:"+contentType);
		return contentType;
	}
	private void responsFile(File file,HttpResponse res) throws Exception{
		BufferedInputStream bis =null;
		try {
			bis =new BufferedInputStream(
					new FileInputStream(file));
			OutputStream out =res.getOutputStream();
			int d=-1;
			while((d =bis.read())!=-1){
				out.write(d);
			}
		} catch (Exception e) {
			throw e;
		}finally{
			if(bis !=null){
				bis.close();
			}
		}
	}
}
