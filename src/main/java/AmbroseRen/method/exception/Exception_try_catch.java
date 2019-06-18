package AmbroseRen.method.exception;

/**
 * java异常处理机制
 *
 */
public class Exception_try_catch {
	public static void main(String[] args) {
		System.out.println("驾驶");
		try{
			String str ="";
			System.out.println(str.length());
			
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
//			try块中异常后以下代码不再运行
			System.out.println("断线了");
			
		}catch(NullPointerException e){
			System.out.println("指针异常");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("下标越界异常");
		/**
		 * catch可以定义多个，根据异常不同办法，分别捕获
		 * 在最后catch最大的异常Exception，可以避免代码出错的
		 * 异常导致程序中断
		 * 当捕获异常的继承关系：子类异常在上先行捕获，父类异常在下	
		 */
		}catch(Exception e){
			System.out.println("反正出错了");
		}
		System.out.println("结束");
	}
}
