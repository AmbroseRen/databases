package AmbroseRen.network.CS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室客户端
 * 
 *
 */
public class Client {
	/**
	 * java.net.Socket 套接字，封装了ＴＣＰ协议，使用它与远程计算机通讯。
	 */
	private Socket socket;

//	建立客户端---并传参
	public Client() throws Exception {
		/**
		 * 客户端开始工作的方法 实例化Socket时需要传入两个参数： 1：服务端计算机的地址信息（IP地址）
		 * 2：服务端计算机上运行的服务端应用和程序申请的服务端口
		 * 
		 * 通过IP可以找到服务端的计算机，通过端口可以连接到运行在服务端的
		 * 
		 * 实例化Socket的过程就是连接服务端的过程 若服务端无响应，实例化过程会抛异常
		 * 
		 * 端口号是一个整数，2字节以内的整数0-65535 但3000以内的端口不要使用，因为紧密的绑定着系统程序， 和世界上流行的应用程序。
		 * 10000以上也很少被使用。
		 */
		try {
			socket = new Socket("172.86.220.94", 8088);

		} catch (Exception e) {
			// 日志记录
			throw e;
		}
	}

//	读入流端口并发送
	public void start() {
		try {
			// byte[] date =message.getBytes();
			/**
			 * Socket提供方法 OutputStream getOutputStream（）
			 * 通过获取的输出流写出的数据就可以通过网络发送给远端的计算机， 对于客户而言远端就是服务端。
			 */
//			写出流数据
			Scanner sc = new Scanner(System.in);
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter ows = new OutputStreamWriter(os, "UTF-8");
			PrintWriter pw = new PrintWriter(ows, true);
//			调用读入流转换方法
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			System.out.println("请开始装逼......");
			String message =null;
			long time =System.currentTimeMillis()-1;
			while (true) {
				 message = sc.nextLine();
				if(System.currentTimeMillis()-time>=1){
					pw.println(message);
					time =System.currentTimeMillis();
				}else{
					System.out.println("你装逼过头了！");
					time =System.currentTimeMillis();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	读入流转换端口(内部转换类)
	private class ServerHandler implements Runnable {
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
//	启动端口
	public static void main(String[] args) {
		Client client;
		try {
			client = new Client();
			client.start();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端启动失败！");
		}
	}
}