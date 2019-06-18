package AmbroseRen.network.Thread;

/**
 * 守护线程
 * 守护线程也称为后台线程
 * 
 * 默认创建出来的线程都是前台线程，若要设置为后台线程
 * 可以通过线程提供的方法setDaemon来完成
 * 
 * 后台线程与前台线程一样，但结束时机不同，即：
 * 当一个进程结束时，所有运行的后台线程都会强制结束。
 * 而进程 的结束时当一个进程中所有前台线程都结束时结束
 * 
 * 可以将开发中需要一直保持运行的任务放在后台线程上，
 * 随程序结束而结束
 *
 */
public class Thread_setDaemon {
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:I'm here.");
				}
			}
		}.start();
		Thread jack =new Thread(){
			public void run() {
				while(true){
					try {
						System.err.println("Jack:You jump,Ijump!");
						Thread.sleep(1000);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		};
//		守护线程必须先于线程启动前完成
		jack.setDaemon(true);
		jack.start();
			
		
		
	}
}

