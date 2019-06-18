package AmbroseRen.method.exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 异常捕获机制在IO中的用法
 * @author 天大java
 *
 */
public class Exception_finally2 {
	public static void main(String[] args) {
		BufferedReader br =null;
		try {
			br =new BufferedReader(
					new InputStreamReader(
							new FileInputStream("./src/main/java/AmbroseRen/method/exception/Exception_finally2.java")));
			String line =null;
			while((line =br.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			
		}finally{
			if(br !=null){
			try {
				br.close();
				
			} catch (Exception e2) {
				
			}
			}
		}
	}
}