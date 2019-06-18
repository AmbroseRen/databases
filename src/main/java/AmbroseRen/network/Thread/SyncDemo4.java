package AmbroseRen.network.Thread;

/**
 * 互斥锁
 * @author 天大java
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Foo foo =new Foo();
		Thread t1 =new Thread(){
			public void run(){
				foo.methodA();		
			}
		};
		Thread t2 =new Thread(){
			public void run(){
				foo.methodB();				
			}
		};
		Thread t3 =new Thread(){
			
		};
		t1.start();
		t2.start();
	}
}
class Foo{
	public synchronized void methodA(){
		Thread t =Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在运行A方法....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+"：运行A方法完毕！");
	}
	public synchronized void methodB(){
		Thread t =Thread.currentThread();
		try {
			System.out.println(t.getName()+":正在运行B方法....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+"：运行B方法完毕！");
	}
}
