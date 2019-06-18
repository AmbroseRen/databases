package AmbroseRen.network.Thread;

/**
 * 线程优先级
 * 对于线程调度的工作，线程不能干涉，
 * 即：线程只能被动的等待分配CPU时间片，而不能主动获取
 * 可以通过修改线程的优先级来最大限度改善获取CPU时间片的几率
 * 理论上，线程优先级越高的线程获取ＣＰＵ时间片的次数越多。
 * 线程的优先级分为１０个等级：即１——１０
 * １最低，１０最高，５默认
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max =new Thread(){
			public void run(){
				for(int i=0;i<10E4;i++){
					System.out.println("max");
				}
			}
		};
		Thread nor =new Thread(){
			public void run(){
				for(int i=0;i<10E4;i++){
					System.out.println("nor");
				}
			}
		};
		Thread min =new Thread(){
			public void run(){
				for(int i=0;i<10E4;i++){
					System.out.println("min");
				}
			}
		};
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		
		min.start();
		nor.start();
		max.start();
	}
}
