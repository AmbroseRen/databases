package AmbroseRen.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Students{
	private String name;
	private int age;
	public Students(String name){
		this.name=name;
	}
	public Students(String name,int age){
		this.name=name;
		this.age=age;
	}
}
public class reflectDemo3 {
	public static void main(String[] args) throws Exception {
		//1)获得类对象
		Class c1 =Class.forName("AmbroseRen.reflect.Students");
		
		//2)-------通过类对象获得构造函数对象------------
		Constructor con1 =c1.getDeclaredConstructor(String.class);
		
		//3)通过构造函数对象构建类的对象
		Object obj =con1.newInstance("王翦");
		System.out.println(obj);
		
		//Class<?> d1 =new Student(String name,int age);
		Constructor<?> con2 =c1.getDeclaredConstructor(String.class,int.class);
		Object obj2 =con2.newInstance("指间",19);
		
		//通过反射获得		属性(Field)对象
		Field f1 =c1.getDeclaredField("name");
		//Field[] fs =c1.getDeclaredFields();
		
		//先设置访问权限
		f1.setAccessible(true);
		//获得obj2对象f1的属性值
		Object f1Value =f1.get(obj2);
		System.out.println(f1Value);
		
		//设置Obj2对象的f1属性的值
		f1.set(obj2, "生死");
		//重新获取设置的值
		f1Value=f1.get(obj2);
		System.out.println(f1Value);
	}
}
