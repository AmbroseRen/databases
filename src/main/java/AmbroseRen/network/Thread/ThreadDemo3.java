package AmbroseRen.network.Thread;

/**
 * 用匿名内部类完成线程的两种创建方式
 * 
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {

		new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("Who are you?");
				}	
			}
			}.start();
			new Thread(new Runnable(){
				public void run(){
					for(int i=0;i<10000;i++){
						System.out.println("I'm is checking water!");
					}		
				}		
		}).start();
		
	}
}
class MyRunnable implements Runnable {
	class MyRunnable1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}