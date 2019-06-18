package AmbroseRen.method.byteStream;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * 缓冲字符输出流
 * 特点：可以按行写出字符串（效率高）
 * PrintWriter自身的最大特点是：“自动行刷新”功能，
 * 缓冲功能靠内嵌的BufferedWriter实现。
 * 实例化PrintWriter时，它总会内部实例化BufferedWriter并与其连接
 *
 */
public class PrintWriter_println {
	public static void main(String[] args) throws IOException {
		/**
		 * pw对文件的构造方法：
		 * PrintWriter（String path）
		 * PrintWriter（File file）
		 * 
		 * 可以使用重载构造方法指定字符集：
		 * PrintWriter（String path，String charsetName）
		 * PrintWriter（）
		 */
		PrintWriter pw =new PrintWriter("pw.txt","utf-8");
		pw.println("月落乌啼霜满天，");
		pw.println("江枫渔火对愁眠。");
		System.out.println("写入完毕");
		pw.close();
	}
}
