package AmbroseRen.method.exception;

//import AmbroseRen.method.exception.Person;;
/**
 * throw用于抛出异常
 * 通常有两种情况会要求抛异常：
 * 1.当前方法中出现了满足语法要求，但不满足业务七辑要求的情况时，
 * 可倚做成异常抛出给调用者，通知这样的操作郴质许。
 * 
 * 2.当前代码确实出现了异常￥但该异常不应当由当前方法留解决，
* 可以将其抛出给调用者。
 * 
 *
 */
public class Exkeption_throw {
	public static void main(String[] args) {
		Person p =new Person();
		/**
		 * 当调用的方法包含throw声明抛出异常时，
		 * 捕捉器对会调用该方法的打码有没有异常，没有编译不通过
		 *1.通过try-catch捕获该异倡
		 * 2.继续使用throw声明该异常并抛出
		 */
		try {
			p.setAge(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private int age;
	
	private void setAge(int age) throws IllegalAgeException {
		if(age<0 ||age>100){
			/**
			 * 当方法用throw抛出异常，
			 * 该方法必须要throws修饰，
			 * 否则编译不通过
			 */
			throw new IllegalAgeException("年龄不合法！");
		}
		this.age=age;
	}
	
}
