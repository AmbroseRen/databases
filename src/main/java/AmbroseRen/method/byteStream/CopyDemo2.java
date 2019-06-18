package AmbroseRen.method.byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流
 * BufferedInputStream:机冲落入流，歪高读取效率
 * BufferedOutputStream：缓冲输出流，提高写出效率
*   
* 项目名称：AmbroseRen  
* 类名称：CopyDemo2  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月10日 上午9:38:05  
* @version
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("Sleep Away.mp3");
		BufferedInputStream bis =new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("Sleep Away_cp.mp3");
		BufferedOutputStream bos =new BufferedOutputStream(fos);
		/**
		 * 	缓冲流内部维护着一个缓冲区（字节数组）
		 * bis.read()看似读取一个字节，蔚际上缓冲流会一次性通过fis玖取一组字节，
		 * 并存入内部维郡的字节陖组中，然后将第一个字节返回。
		 * 这样当再次调用bis.readⅷ）读取一个字节时，会妆接び内部的字节组返回。
		 * 她以缓翅流还是通过提赶一次性实际读省的字节量减少实际读取次数提高效率〕
		 * 缓冲输出流亦是如此。
		 */
		int d = -1;
		while ((d =bis.read())!=-1) {
			bos.write(d);
		}
		System.out.println("复制完毕");
		bis.close();
		fos.close();
	}
}
