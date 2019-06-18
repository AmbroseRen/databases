package AmbroseRen.reflect;

class Point{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

public class reflectDemo1 {
	public static void main(String[] args) throws Exception {
		//编译时已确定会构建哪个类的对象
		//这个过程称之为静态过程
		Point p1 =new Point();//类的实例化
		p1.getX();
		
		//获取Point类的类对象
		Class<?> c1 =p1.getClass();
		Object a =c1.getClassLoader();
		System.out.println("a=="+a);
		Class<?> c2 =Point.class;
		//重点记住如下类的加载方式__“由包地址及类”加载
		Class<?> c3 =
				Class.forName("AmbroseRen.demo2.reflect.Point");
		System.out.println(c1==c2);//true
		System.out.println(c2==c3);//true
		System.out.println("c3=="+c3);
		
		//FAQ 类加载时会有对应的加载器，如何发现此类对应的类加载器是谁？
		ClassLoader loader =ClassLoader.getSystemClassLoader();
		System.out.println(loader);//AppClassLoader
		ClassLoader pLoader =loader.getParent();
		System.out.println(pLoader);//ExtClassLoader
		ClassLoader ppLoader =pLoader.getParent();
		System.out.println(ppLoader);//null(BootstarpClassLoader)
		
		//各加载器的职责
		//1)BootstarpClassLoader (jdk/jre/lib包中的jar文件)
		//2)ExtClassLoader(jdk/jre/lib/ext包中的文件)
		//3）AppClassLoader(自己写的类)
		//类加载器扩展：自己定义类加载器(继承ClassLoader)
	}
}
