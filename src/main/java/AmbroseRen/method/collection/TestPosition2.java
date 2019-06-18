package AmbroseRen.method.collection;

import AmbroseRen.method.collection.Position;

/**
 * 泛型是1.5以后推出的新特性
 * 泛型也是编译器认可，而非虚拟机。
 * 原型为Object
 * 泛型是编译器在编译源码的时候做的：
 * 1：检查参数是否与泛型类型一致
 * 2：获取泛型类型时进行类型转换
 *
 */
public class TestPosition2 {
	public static void main(String[] args) {
		Position<Integer> p1 =new Position<Integer>(1,2);
		p1.setX(4);
		/**
		 * int x1 =(Integer)p1.getX().inValue();
		 * 帮助造型
		 */
		int x1 =p1.getX();
		System.out.println("x1:"+x1);
		
		//泛型不指定时用默认原型：Object
		Position p2 =p1;
		System.out.println(p2.getX());
		p2.setX("二");
		System.out.println(p2.getX());
		
		/**
		 * 测造型异常
		 */
		x1 =p1.getX();
		System.out.println("x1:"+x1);
		
	}
}

