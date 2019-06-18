package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

import AmbroseRen.method.Point;

/**
 * 集合存放的是元素的引用
 * @author 天大java
 *
 */
public class CollectionDemo2 {

	public static void main(String[] args) {
		Collection<Point> c =new ArrayList<Point>();
		Point p =new Point();
		p.setX(2);
		p.setY(3);
		c.add(p);
		System.out.println(c);
		System.out.println(p);
		
		//元素改动了，集合也跟着改变！！！！！！
		p.setY(50);
		System.out.println(c);
		System.out.println(p);

	}

}

