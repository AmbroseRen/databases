package AmbroseRen.network.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程提供了一个静态方法
 * static void sleep（long ms）
 * 该方法会将运行当前方法的线程阻塞（指ms）
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
			while(true){
//				Timer time =new Timer();
//				Date time =new Date();
				System.out.println(sdf.format(new Date()));
				
//				System.out.println(sdf.parse(source));
				Thread.sleep(1000);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over");
	}
}

