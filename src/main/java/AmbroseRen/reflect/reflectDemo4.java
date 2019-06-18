package AmbroseRen.reflect;

import java.lang.reflect.Method;

class Teacher{
	private String name;
	public void setName(String name){
		this.name=name;
		return;
	}
	//
	public String getName(){
		return name;
	}
}
public class reflectDemo4 {
	public static void main(String[] args) throws Exception {
		Class<?> c1 =Class.forName("AmbroseRen.reflect.Teacher");
		Object obj1 =c1.newInstance();
		
		//-----------通过类对象获得方法对象--------------------
		Method m1 =
				c1.getDeclaredMethod("setName", String.class);
		//执行方法对象（动态执行）
		//执行obj1对象的m1方法，传参为"name1"
		Object result =m1.invoke(obj1, "name1");
		Method m2 =c1.getDeclaredMethod("getName");//绑定方法
		/**
		 *执行obj1对象的m2方法 
		 */
		//result =m2.getName();
		result =m2.invoke(obj1);
		System.out.println(result);
	}
}
