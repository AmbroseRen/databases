package AmbroseRen.method.byteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制文件
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/**
		 *使用文件输入流将源文件中的所有字节
		 *顺序的读入再用文件输出流写出到另一个文件中
		 *完成复制操作
		 */
		/*FileOutputStream fos1 =new FileOutputStream("test1.txt");
		//读入字符串并编码
		String str ="二次读入字符串并测试";
		byte[] date =str.getBytes("utf-8");
		fos1.write(date);
		System.out.println("读入完毕");*/
		
		
		FileInputStream fis =new FileInputStream("登录.jpg");
		
		FileOutputStream fos =new FileOutputStream("登录_cp2.jpg");
		byte[] date =new byte[1024*10];
		int len =-1;
		
		while((len =fis.read(date))!=-1){
			fos.write(date,0,len);
		}
		System.out.println("复制完毕");
		fis.close();
		fos.close();
	}
}
