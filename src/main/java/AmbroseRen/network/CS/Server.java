package AmbroseRen.network.CS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//import day11.Server;
//import day11.Server.ClientHandler;

/**
 * 聊天室服务端
 * 
 *
 */
public class Server {
	/**
	 * 运行在服务端的serverSocket主要负责两个工作： 1：向系统申请服务端口，客户端就通过这个端口与服务端应用程序建立连接。
	 * 2：监听服务端口，一旦客户端通过该端口尝试连接时，ServerSocket就会实例化 一个Socket与该客户端通讯。
	 */
	private ServerSocket server;
	private List<PrintWriter> allOut;
	public Server() throws Exception {
		try {

			/**
			 * 实例化ServerSocket时需要指定服务口， 客户端就是通过这个端口与服务端建立连接的。
			 * 
			 * 该端口不能与系统其它程序申请的端口冲突，否则就会抛异常。 address already in use
			 */
			server = new ServerSocket(8088);
			allOut =new ArrayList<PrintWriter>();
			
		} catch (Exception e) {
			throw e;
		}
	}

	public void start() {
		try {
			while (true) {

				System.out.println("等待客户端连接......");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了！");
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			

				Server server = new Server();
				server.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败");
		}
	}

	/**
	 * 该线程任务是用于处理与指定客户端的交互工作。
	 */
	private class ClientHandler implements Runnable {
		// 当前线程通过这个Socket与指定客户端交互
		private Socket socket;
		private String host;

		public ClientHandler(Socket socket) {
			this.socket = socket;
			// 通过Socket获取远端计算机地址信息
			InetAddress address = socket.getInetAddress();
			// 获取IP地址的字符串形式
			host = address.getHostAddress();
		}
		public void run() {
			PrintWriter pw =null;
			try {

				/**
				 * ServerSocket提供方法： Socket accept（） 该方法是一个阻塞方法，调用后会一致等待客户端连接，
				 * 一旦一个客户通过ServerSocket申请的端口建立连接， 那么accept方法会返回一个Socket实例，
				 * 通过该Socket实例可以与建立连接的客户端进行通讯。
				 */

				/**
				 * Socket提供方法： InputStream getInputStream()
				 * 通过获取的输入流读取的字节就是来自远端发送过来的数据 对于服务端而言，远端就是客户端。
				 */

				InputStream in = socket.getInputStream();
				// 读入缓冲流
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);

				/**
				 * 通过Socket获取输出流，发送消息给客户端
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				 pw = new PrintWriter(osw,true);
//				将该客户端的输出流存入共享集合
				synchronized (allOut) {
					
					allOut.add(pw);
				}
				String message ;
				
				while ((message = br.readLine()) != null) {
					System.out.println(host+"say："+message);
					/**
					 * 将消息发给所有客户端
					 * 
					 * 线程在遍历时的操作要与集合的增删元素互斥
					 */
					synchronized(allOut){
						for(PrintWriter o:allOut){
							o.println(host+"say:"+message);
						}
						
					}
//					System.out.println(host + "say:" + message);
//					pw.println(host + "say:" + message);
				}

				/**
				 * 使用br.readLine读取客户端发送过来的一行字符串时，
				 * 该方法会处于阻塞状态，直到客户端真实发送过来一行，这里才会返回。
				 * 但当客户端断开连接时，br.readLine会根据客户端不同操作系统有不同的反馈。
				 * 当windows的客户端断开，br.readLine方法会抛出异常。
				 * 当linux的客户端断开，br.readLine方法会返回null值。
				 */
				while ((message = br.readLine()) != null) {

					// String message =br.readLine();
					System.out.println(host + "say：" + message);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally{
//				处理断开连接操作
//				将该客户端的输出流从共享集合中移出
				synchronized (allOut) {
					
					allOut.remove(pw);
					
				}
			}
		}

	}

}
