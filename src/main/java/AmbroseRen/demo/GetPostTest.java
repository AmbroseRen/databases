package AmbroseRen.demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class GetPostTest {
	public static void main(String[] args) {
		//1、创建一个服务器端的Socket[ServerSocket]
		ServerSocket ss=null;
		Socket s=null;
		BufferedInputStream bis=null;
		BufferedReader br=null;
		try
		{	ss=new ServerSocket(3306);
			//2、调用ServeSocket的accept方法，等待客户端发送过来的连接[Socket]
			s=ss.accept();
			//3、通过Socket获取输入流或者输出流
		     InputStream os=s.getInputStream();//使用输出流发送给客户端
		    //4、封装输入输出流，让读取速度更快
		     bis=new BufferedInputStream(os);
		     br=new BufferedReader(new InputStreamReader(bis));
		     //5、读，写数据
		     //在此处我们进行数据的读取
	    	                String line;
     		                line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
				line=br.readLine();
				System.out.println(line);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			//6、关闭资源
				try {
					br.close();
					s.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}

