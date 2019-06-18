package AmbroseRen.network.Thread;


/**
 * 多线程并发安全问题
 * 当多个线程访问同一资源时，由于线程时机不确定
 * 导致代码未按照设计方式的顺序执行导致的逻辑混乱。
 * 严重时，可能导致系统瘫痪。
 * @author 天大java
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table =new Table();
		Thread t1 =new Thread(){
			public void run(){
				while(true){
					int bean =table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		
		};
		Thread t2 =new Thread(){
			public void run(){
				while(true){
					int bean =table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		
		};
		t1.start();
		t2.start();
		
	}
	
}
class Table{
	private int beans =20;
	/**
	 * 解决线程并发安全的手段是将“各干各的”变为“排队执行”
	 * 
	 * 当一个方法被synchronized修饰后，那么该方法称为同步方法，
	 * 即：多个方法不能同时进入到方法内部执行。
	 *
	 *在方法上使用synchronized修饰后，上锁的对象就是
	 *当前方法所属对象，即：方法中看到的this
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException(":::没豆子了");
		}
		Thread.yield();//模拟线程切换
		return beans--;
	}
}

