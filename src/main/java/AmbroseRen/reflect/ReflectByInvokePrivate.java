package AmbroseRen.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PrivateDemo{
	
	private String userName="张三";
	
	private String sayHello(String name){
		return "Hello "+name;
	}
	
	public String getUserName(){
		return userName;
	}
}
public class ReflectByInvokePrivate {
	
	public static void main(String[] args) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		PrivateDemo pDemo=new PrivateDemo();
		Class<?> classType=pDemo.getClass();//创建该对象的class对象
		Method m=classType.getDeclaredMethod("sayHello", new Class[]{String.class});//通过class对象获取需要调用的方法
		m.setAccessible(true);//压制java检查机制  使得private可访问   
		String result= (String)m.invoke(pDemo, new Object[]{"dawson"});
		
		System.out.println(result);
		
		System.out.println("-------------------华丽的分割线----------------------");
		Field feild=classType.getDeclaredField("userName");//获取对应的属性
		feild.setAccessible(true);//压制java检查
		feild.set(pDemo, "李四");//设置该属性的值
		
		Method m1=classType.getDeclaredMethod("getUserName", new Class[]{});
		m1.setAccessible(true);
		result= (String)m1.invoke(pDemo, new Object[]{});
		
		System.out.println(result);

	}
	
}
