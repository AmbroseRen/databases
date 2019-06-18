package AmbroseRen.method.byteStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流
 * 可以按行读取字符串
 *
 */
public class BufferedReader_readLine {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =new FileInputStream("."+File.separator+
				"src"+File.separator+
				"main"+File.separator+
				"java"+File.separator+
				"AmbroseRen"+File.separator+
				"method"+File.separator+
				"byteStream"+File.separator+
				"BufferedReader_readLine.java");
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br =new BufferedReader(isr);
		/**
		 * =====
		 * BufferedReader提供了读取一行字符串的方法：
		 * String readLine（）
		 * 该方法会顺序读取若干字符串，直到读取换行符为止，
		 * 然后将换行符之前的所有字符以字符串的形式返回。
		 * 若为null，则表示文件末尾。
		 */
		String line =null;
		while((line =br.readLine())!=null){
			System.out.println(line);
		}
	}
}

