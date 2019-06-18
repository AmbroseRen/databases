package AmbroseRen.method.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 *
 */
public class RandomAccessFile_read {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =new RandomAccessFile("test.txt","r");
		/**
		 * int read()
		 * 读取一个字节，并存到int值中，返回该int值
		 * 值为-1，则表示在文件末尾
		 */
		int i;
		 i =raf.read();
		System.out.println(i);
		i =raf.read();
		System.out.println(i);
		i =raf.read();
		System.out.println(i);
		i =raf.read();
		System.out.println(i);
		i =raf.read();
		System.out.println(i);
	}

}

