package AmbroseRen.method.exception;

/**
 * 异常常用方法
 */
public class Exception_API {
	public static void main(String[] args) {
		System.out.println("run");
		try {
			String str ="abc";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			//输出错误堆栈信息
			e.printStackTrace();
			
			//obtain error message
			String message =e.getMessage();
			System.out.println(message);
		}
		System.out.println("over");
	}
}

