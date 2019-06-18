package AmbroseRen.network.Thread;

//import day09.MyRunnable1;
//import day09.MyRunnable2;

/**
 * 第二种创建线程的方式：
 * 实现Runnable接口并重写run方法来单独定义任务
 * 
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 =new MyRunnable1();
		Runnable r2 =new MyRunnable2();
		
		Thread t1 =new Thread(r1);
		Thread t2 =new Thread(r2);
		
		t1.start();
		t2.start();
	}
}
class MyRunnable1 implements Runnable{
	public void run(){
		for(int i=0;i<100000100;i++){
			System.out.println("Who are you?");
		}
		
	}
}
class MyRunnable2 implements Runnable{
	public void run(){
		for(int i=0;i<10000100;i++){
			System.out.println("I'm is checking water.");
		}
	}
}
