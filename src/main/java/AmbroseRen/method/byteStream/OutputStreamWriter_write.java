package AmbroseRen.method.byteStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流
 * 字符流与字节流的区别在于读写单位为：字符
 * 字符流底层本质还是读写字节，字节转字符的工作
 * 交给了字符流来完成
 * 读取字符的方法：Rreader（），是所有字符输入流的父类
 * 写出字符的方法：Writer（），是所有字符输出流的父类
 * 
 * 转换流
 * InputStreamReader，OutputStreamWriter
 * 是字符流的常见实现类
 * @author 天大java
 *
 */

public class OutputStreamWriter_write {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos =new FileOutputStream("osw.txt");
		OutputStreamWriter osw =new OutputStreamWriter(fos,"utf-8");
		osw.write("千山鸟飞绝");
		osw.write("，万径人踪灭");
		System.out.println("写出完毕");
		osw.close();
		
		

	}

}
