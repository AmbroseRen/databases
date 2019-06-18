package AmbroseRen.network.Thread;

/**
 * 静态方法使用synchronized，一定具有同步效果
 *
 *静态方法上锁的对象是该方法所属类的类对象
 *实际上ＪＶＭ在加载一个类的ｃｌａｓｓ文件时，
 *会实例化一个Ｃｌａｓｓ类型的实例去保存该类的信息（属性，方法等），
 *所以ＪＶＭ中每个加载过的类都有且只有一个ｃｌａｓｓ的实例用于表示它，
 *这个ｃｌａｓｓ的实例就是该类的类对象
 */
public class SyncDemo3 {
	public static void main(String[] args) {
//		Boo b =new Boo();
		final Thread t1 =new Thread(){
			public void run(){
				Boo.boo();
			}
		};
		Thread t2 =new Thread(){
			public void run(){
				Boo.boo();
			}
		};
		t1.start();
		t2.start();
	}
}
class Boo{
	public static synchronized  void boo(){
		Thread t =Thread.currentThread();
		System.out.println(t.getName()+":正在运行boo......");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+"运行结束！");
	}
}
