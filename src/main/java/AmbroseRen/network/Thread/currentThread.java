package AmbroseRen.network.Thread;

public class currentThread {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("runing main's Thread=="+main);
		long id =main.getId();
		System.out.println("main id=="+id);
//		优先级
		int priority =main.getPriority();
		System.out.println("main优先级："+priority);
		boolean isAlive =main.isAlive();
		System.out.println("isAlive=="+isAlive);
//		是否为守护进程（即：后台进程）
		boolean isDaemon =main.isDaemon();
		System.out.println("isDaemon=="+isDaemon);
//		线程是否被中断
		boolean isInterrupted =main.isInterrupted();
		System.out.println("isInterrupted=="+isInterrupted);
		
		ThreadOne();
	}
	
	public static void ThreadOne(){
		Thread t =new Thread(){
			public void run(){
				new Thread();
				Thread ThreadOne =Thread.currentThread();
				System.out.println("ThreadOne=="+ThreadOne);
			}
		};
		t.start();
		System.out.println("t优先级："+t.getPriority());
	}
	
}
