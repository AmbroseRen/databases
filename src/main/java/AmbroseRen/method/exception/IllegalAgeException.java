package AmbroseRen.method.exception;

/**
 * 自定义异常
 * 自定义异常通常用来说明业务逻辑级别的异常
 * 
 * 年龄不合法异常
 *
 */
public class IllegalAgeException extends Exception{

	private static final long serialVersionUID = -8241398737954702031L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}

