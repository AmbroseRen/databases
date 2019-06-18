package AmbroseRen.network.CS;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import AmbroseRen.network.CS.ServerContext;
import AmbroseRen.network.CS.WebServer;

public class WebServer {
	private ServerSocket server;
	private ExecutorService ThreadPool;
	
	public WebServer() throws Exception{
		try {
			server =new ServerSocket(ServerContext.ServerPort);
			ThreadPool =Executors.newFixedThreadPool(ServerContext.max_thread);
		} catch (Exception e) {
			throw e;
		}
	}
	public void start(){
		try {
			while(true){
				System.out.println("等待客户端连接");
				Socket socket =server.accept();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			WebServer server =new WebServer();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败！");
		}
	}
}
