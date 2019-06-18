package AmbroseRen.method.byteStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 完成记事本功能
 * 程序启动用户输入文件名，然后将控制台输入的
 * 每行字符串写入该文件中
 * 输入“exit”退出。
 *
 */
public class Note {
	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		System.out.println("请输入文件名");
		String str =sc.nextLine();
		/**当创建PrintWriter时，如果使用的构造方法中第一个参数是一个流，
		那么就支持一个重载的构造方法可以在传入一个boolean值的参数
		若该值为true，则当前PrintWriter具有自动刷新功能，
		即：每当使用Println方法写出一行字符串后会自动flash*/
		File file =new File(str);
		PrintWriter pw =
				new PrintWriter(
						new OutputStreamWriter(
								new FileOutputStream(file),"utf-8"),true);
		System.out.println("请输入文本内容");
		String line =null;
		while(true){
			line =sc.nextLine();
//			pw.flush();
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
		}
		pw.close();
	}
}