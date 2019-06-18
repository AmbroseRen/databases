package AmbroseRen.reflect;

import java.util.Scanner;

public class reflectDemo2 {
	public static void main(String[] args) throws Exception {
		System.out.println("please input class");
		Scanner sc =new Scanner(System.in);//创建的类的类路径：AmbroseRen.reflect.reflectDemo2
		String className =sc.nextLine();
		//构建输入的类名构建对象----动态构建对象
		Class<?> c1 =Class.forName(className);
		Object obj =c1.newInstance();
		System.out.println(obj);
		sc.close();
	}
}

