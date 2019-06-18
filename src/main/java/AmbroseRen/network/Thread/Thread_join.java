package AmbroseRen.network.Thread;

/**
 * 线程的join()方法可以协调线程间同步运行
 *
 */
public class Thread_join {
//	标识图片是否下载完毕
	private static boolean isFinish = false;
	public static void main(String[] args) {
		/**
		 * 当一个方法的局部内部类中需要引用该方法的其他局部变量时
		 * 该局部变量必须是final的
		 * 在这里main方法的局部内部类show中想引用main方法的其他局部变量download，
		 * 那么download就必须是final的
		 * JDK1.8之后由于内存问题被重新定义，不再有这个问题，所以不再需要做上述设定。
		 */
		final Thread download =new Thread(){
			public void run(){
				System.out.println("down:开始下载图片....");
				for (int i = 0; i <100; i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
					isFinish =true;
				}
				System.out.println("down:下载完毕！");
			}
		};
		Thread show =new Thread(){
			public void run(){
				System.out.println("show:开始显示图片...");
				
				/**等待线程download完成再启动*/
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("图片显示异常");
				}
				System.out.println("show：图片显示完毕");
			}
		};
		download.start();
		show.start();
		
	}
	
}

