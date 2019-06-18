package AmbroseRen.method.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读写效率差，块读写效率高
 * 提高效率：提高每次读写的数据量，减少读写次数
 * @author 天大java
 *
 */
public class CopyDemo2 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src =new RandomAccessFile("Sleep Away.mp3","r");
		RandomAccessFile doc =new RandomAccessFile("Sleep Away_a.mp3","rw");
		/**
		 * RandomAccessFile提供了一次读写一组字节的方法：
		 * 
		 * int read（byte[]date）
		 * 一次性读取给定字节数组length的字节量，并存入到该数组中，
		 * 返回值为实际读取的字节量
		 * 若返回值为：-1
		 * 
		 * void write（byte[] date,int offset,int len）
		 * 将给定字节数组从下标offset处的字节开始连续
		 */
		long a =System.currentTimeMillis();
		byte[] date =new byte[1024*10];
		int len =-1;
		while((len =src.read()) !=-1){
			doc.write(date,0,len);
		}
		long b =System.currentTimeMillis();
		System.out.println(b-a);
		src.close();
		doc.close();
	}

}

