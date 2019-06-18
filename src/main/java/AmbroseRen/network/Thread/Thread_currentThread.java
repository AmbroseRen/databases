package AmbroseRen.network.Thread;

/**
 * 线程提供了一个静态方法：
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程
 * 
 *java中所有代码都是靠线程运行的，main方法也不例外。
 *只是运行main方法的线程不是由我们创建的。
 *
 */
public class Thread_currentThread {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("runing main's Thread method is:"+main);
		Thread t =new Thread(){
			public void run(){
				Thread t =Thread.currentThread();
				System.out.println("User-defined:"+t);
				dosome();
			}
		};
		t.start();
	}
	public static void dosome(){
		Thread t =Thread.currentThread();
		System.out.println("Currenting Thread is:"+t);
	}
}
