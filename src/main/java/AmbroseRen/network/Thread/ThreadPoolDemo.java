package AmbroseRen.network.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题：
 * 1.控制线程数量。因为线程多了，会导致内存开销大，
 * 严重时会导致系统瘫痪，并且由于线程数量多
 * 会导致CPU过度切换，拖慢系统响应。
 * 2.重用线程
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
//		创建线程池
		ExecutorService threadPool =Executors.newFixedThreadPool(2);
		for (int i = 0; i <5; i++) {
			Runnable runn =new Runnable(){
				public void run() {
					try {
						Thread t =Thread.currentThread();
						System.out.println(t.getName()+"正在运行...");
					} catch (Exception e) {
						System.out.println("线程被中断了！");
					}
					
				}
			};
			threadPool.execute(runn);//运行线程
			System.out.println("指派任务给线程池！运行完毕！");
		}
		threadPool.shutdown();
		System.out.println("停止线程池！");
	}
}

