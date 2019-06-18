package AmbroseRen.method.byteStream;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符串
 *
 */
public class RandomAccessFileDemo3 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =new RandomAccessFile("我.txt","r");
		byte[] date =new byte[100];
		int len =raf.read(date);
		/**
		 * string(byte[] date)
		 * 转给定字节数组为当前默认系统对应字符串
		 * 
		 * String(byte[] date,int offset,int len)
		 * 将给定字节数组从下标offset处开始连续的len个字节转换为
		 * 按默认系统转换为字符串
		 */
		String str =new String(date,0,len,"utf-8");
		System.out.println(str);
		raf.close();
	}

}
