package AmbroseRen.method.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 *
 */
public class CopyDemo1 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src =new RandomAccessFile("登录.jpg","r");
		RandomAccessFile cp =new RandomAccessFile("登录_cp.jpg","rw");
		int d=-1;
//		byte[] date =new byte[1024*10];
		long start =System.currentTimeMillis();
		while((d =src.read())!=-1){
			cp.write(d);
		}
		long end =System.currentTimeMillis();
		System.out.println(end-start);
		src.close();
		cp.close();
	}

}

