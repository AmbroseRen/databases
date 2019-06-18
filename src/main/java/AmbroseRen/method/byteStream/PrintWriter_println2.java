package AmbroseRen.method.byteStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 在流连接中使用PrintWriter
 *
 */
public class PrintWriter_println2 {

	public static void main(String[] args) throws IOException {
		PrintWriter pw =
				new PrintWriter(
						new OutputStreamWriter(
								new FileOutputStream("pw2.txt")));
		pw.print("你好！");
		pw.print("再见！");
		System.out.println("执行完毕");
		pw.close();
	}

}

