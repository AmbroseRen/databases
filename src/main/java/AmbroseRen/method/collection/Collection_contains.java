package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

import AmbroseRen.method.collection.Point;;


/**
 * 判断当前集合是包含给定元素
 *
 */
public class Collection_contains {

	public static void main(String[] args) {
		Collection<Point> c =new ArrayList<Point>();
		c.add(new Point(1,2));
		c.add(new Point(2,3));
		c.add(new Point(3,4));
		
		Point p =new Point(2,3);
		boolean tf =c.contains(p);
		System.out.println(tf);
		
		c.add(p);
		System.out.println(c);
		c.removeAll(c);
		System.out.println(c);
	}

}

