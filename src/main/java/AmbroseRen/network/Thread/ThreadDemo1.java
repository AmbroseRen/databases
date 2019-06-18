package AmbroseRen.network.Thread;

import java.util.concurrent.SynchronousQueue;

/**
 * 多线程
 * 多线程允许我们可以“同时”执行多段代码。
 * 
 * 实际上多线程是并发运行的，即：JVM中的线程调度会为多个线程分配”CPU时间片“
 * 并将这些线程尽可能均匀的分配给线程，当一个线程获取时间片后，该线程的任务代码
 * 被CPU执行，其他线程处于等待状态。
 * 这种宏观上同时运行而微观上走走停停的现象称为并发。
 * 
 * java中的线程是由Thread的实例表示。
 * 而Thread的创建有两种方式：
 * 1.继承Thread并重写run方法
 * 
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 =new MyThread1();
		Thread t2 =new MyThread2();
		/**
		 * start thread is call
		 * 启动线程是调用线程的start方法，而不是直接调用run方法
		 * start方法的作用是将该线程纳入线程调度。
		 * 一旦start方法执行完毕，该线程的run方法会很快被运行
		 * （只要获取了ＣＰＵ时间片）
		 * 
		 * 线程间是并发运行代码，两段代码不存在先后顺序运行的概念。
		 * 有先后顺序运行多段代码称为：同步执行
		 * 多线程是在运行多段代码时是：异步运行（各自执行的）
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 并发线程的不足：
 * 1.由于java是单继承，导致在实际开发中，为了
 * 复用一个类的方法，我们需要继承那个类，而自身又希望是一个线程时导致的冲突问题。
 * 2.继承线程需要重写run方法来定义该线程执行的任务代码，
 * 就导致了线程与执行的任务有一个必然的耦合关系，不利于线程的重用。
 * 
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i = 0;i<1000;i++){
			System.err.println("Who are you?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("I'm is checking water.");
		}
	}
}
