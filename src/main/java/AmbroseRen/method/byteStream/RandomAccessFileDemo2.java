package AmbroseRen.method.byteStream;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写入字符串
 *
 */
public class RandomAccessFileDemo2 {

	public static void main(String[] args) throws IOException {
		//创建文本
		RandomAccessFile raf =new RandomAccessFile("我.txt","rw");
//编码	写入文件
		String str ="写入文件";
		/**
		 * byte[] getbytes(String csn)
		 * 将当前字符串按照给定字符集转换为一组对应的字节
		 * csn:charset name
		 * 常用字符集：
		 * gbk,utf-8,iso8859-1(欧洲编码，不支持中文)
		 */
//解码	读取字符串文件并还原
		byte[] date =str.getBytes(  "utf-8"   );
		raf.write(date);
		raf.close();
	}

}