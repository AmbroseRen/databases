package AmbroseRen.network.Thread;

/**
 * Obtaining Thread's methods()
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		Thread main =Thread.currentThread();
		
		long id =main.getId();
		System.out.println("ID:"+id);
		
		String name =main.getName();
		System.out.println("name:"+name);
//		优先级
		int priority =main.getPriority();
		System.out.println("优先级："+priority);
		
		boolean isAlive =main.isAlive();
		System.out.println("isAlive:"+isAlive);
//		是否为守护进程（即：后台进程）
		boolean isDaemon =main.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
//		线程是否被中断
		boolean isInterrupted =main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
	}
}

