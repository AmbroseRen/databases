package AmbroseRen.method.exception;

/**
 * finally块
 * finally块只能定义在异常捕获机制的最后一块
 * finally能确保无论try块中的代码是否抛出异常，
 * finally块中的代码都会执行
 * 
 * 所以finally块中的代码通常都是无关乎程序是否报错都要执行的代码
 * 如：IO流中，关闭流的操作就该放在finally块中以确保执行。
 * @author 天大java
 *
 */
public class Exception_finally {
	public static void main(String[] args) {
		System.out.println("start");
		try {
			String str ="";
			System.out.println(str.length());
		} catch (Exception e) {
			System.err.println("program Exception");
		}finally{
			System.out.println("finally is run");
		}
		System.out.println("over");
	}
}

