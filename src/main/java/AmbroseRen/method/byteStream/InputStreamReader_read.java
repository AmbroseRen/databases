package AmbroseRen.method.byteStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换输入流InputStreamReader
 *
 */
public class InputStreamReader_read {

	public static void main(String[] args) throws IOException {
		FileInputStream fis =new FileInputStream("osw.txt");
		InputStreamReader isr =new InputStreamReader(fis,"utf-8");
		/*指针循环*/
		int p = -1;
		while((p =isr.read())!=-1){
			System.out.print((char)p);
		}
		isr.close();
	}

}

