package AmbroseRen.method.byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream_read {
	/*初始化静态变量加static*/
	private InputStream is;
	private static FileInputStream fis;
	
	public static void main(String[] args) throws IOException {
		 fis = new FileInputStream("fos.txt");
		byte[] data =new byte[200];
		int len =fis.read(data);
		//字符串读入编码
		String str =new String(data,0,len, "utf-8");
		System.out.println(str);
		fis.close();
	}
}
