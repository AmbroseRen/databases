package AmbroseRen.method.byteStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutStream_write {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos =new FileOutputStream("fos.txt");
		String str ="输入流读入数据";
		byte[] data =str.getBytes("UTF-8");
		fos.write(data);
		System.out.println("读入完毕");
		/**
		 * 默认创建的文件输出流是：覆盖读入操作
		 * 即：若该文件存在．会侨清除该文件的数据，
		 * 然后通过该流汛出的J莼崾亲旌蟛僮鞯奈
		 * RAF写出则不同，RAF淑写出多少数据则覆盖多少数据。
		 * 
		 * FOS蕨持另一种构造窛法，要求传入两个参数，
		 * 第二个则为boolean值，若该值为true
		 *  则是追接读入模式，湐：该流的数据会被追加�=文件末尾。
		 */
		String str1 ="输入流";
		byte[] data1 =str1.getBytes("UTF-8");
		fos.write(data1);
		fos.close();
	}
}
