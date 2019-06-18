package AmbroseRen.method.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RAF是用来读写文件数据的。其基于指针进行读写，总是在指针当前位置读写字节，并且读写完毕后自动后移。
 * 
 *
 */
public class RandomAccessFile_write {

	public static void main(String[] args) throws IOException {
		/**
		 * RAF有两种常见的创建模式：
		 * 1.只读模式，进行文件读取
		 * 2.读写模式
		 * 
		 * ＲＡＦ的构造方法：
		 * RandomAccessFile(File file,String mode)   
		 * RandomAccessFile(File path,String mode)   
		 * 第一个参数指定要读写的文件，第二个参数为字符串，常用的两个：
		 * 1："rw":读写模式
		 * 2："r":只读模式
		 */
		RandomAccessFile raf =new RandomAccessFile("test.txt","rw");
			raf.write(97);
			raf.write(65);
			raf.write(48);
			raf.write(1000);
			System.out.println("写完了");
	}

}
