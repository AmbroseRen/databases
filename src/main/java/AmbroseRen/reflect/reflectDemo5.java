package AmbroseRen.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class reflectDemo5 {
	public static void main(String[] args) throws Exception, Exception {
		ArrayList<String> list =new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);//错误
		
		//通过动态调用将100写入集合
		Class<?> c1 =list.getClass();
		//----------通过类对象获得方法对象---------------
		Method m = c1.getDeclaredMethod("add",Object.class);
		m.invoke(list, 100);
		System.out.println(list);
	}
}
