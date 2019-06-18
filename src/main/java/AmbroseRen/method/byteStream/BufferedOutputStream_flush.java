package AmbroseRen.method.byteStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流写出数据的缓冲区问题
 *
 */
public class BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		//缓冲加速读取文件数据
// 		FileOutputStream fos =new FileOutputStream("fos.txt");
//		BufferedOutputStream bos =new BufferedOutputStream(fos);
		BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("fos.txt"));
		
		String str ="让我在看你一次，从南到北";
		byte[] date =str.getBytes("utf-8");
		bos.write(date);
		bos.flush();

		String str1 ="让我再看你一次，从南到北！";
//		解码输出
		byte[] date1 =str1.getBytes("utf-8");
		bos.write(date1);
		bos.flush();
		System.out.println("写出完毕");
		bos.close();
		
	}
}
