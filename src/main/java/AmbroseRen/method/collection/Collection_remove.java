package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 删除集合元素
 * boolean remove(E e)
 *
 */
public class Collection_remove {

	public static void main(String[] args) {
		Collection<Point> c =new ArrayList<Point>();
		c.add(new Point(1,2));
		c.add(new Point(2,3));
		c.add(new Point(3,4));
		c.add(new Point(2,3));
		Point p =new Point(2,3);
		c.remove(p);
//		p.equals(c==null ? p==null : c.equals(p));
		System.out.println("已删除");
		System.out.println(c);

	}
 
}
