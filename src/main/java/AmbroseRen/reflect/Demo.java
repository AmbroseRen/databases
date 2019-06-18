package AmbroseRen.reflect;

import java.lang.Integer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
	public static void main(String[] args) 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		 Integer integer =new Integer(0);
		 Class<?> classTpe =integer.getClass();
		 //调不动啊我艹我艹
		 Method method =classTpe.getDeclaredMethod("java.lang.Integer.toUnsignedString", Object.class);
		 method.setAccessible(true);
		 String result =(String)method.invoke(integer,new Object[]{10,11});
		 System.out.println(result);
	}
	
}
