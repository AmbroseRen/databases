package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AmbroseRen.method.collection.Point;

/**
 * 排序含有自定义类元素的List集合
 * @author 天大java
 *
 */
public class SortListDemo2 {

	public static void main(String[] args) {
		List<Point> list =new ArrayList<Point>();
		list.add(new Point(1,2));
		list.add(new Point(2,3));
		list.add(new Point(5,6));
		list.add(new Point(3,4));
		list.add(new Point(4,5));
		System.out.println(list);
		
		/**
		 * sort（）方法要求集合元素必须实现Comparable接口
		 * 否则无法排序
		 */
		Collections.sort(list);
		System.out.println(list);
	}

}
