package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合的集合操作
 *
 */
public class Collection_addAll {

	public static void main(String[] args) {
		Collection<String> c1 =new HashSet<String>();
		c1.add("java");
		c1.add("c++");
		c1.add("php");
		System.out.println("c1集合为："+c1);
		
		Collection<String> c2 =new ArrayList<String>();
		c2.add(".net");
		c2.add("java");
		c2.add("c#");
		System.out.println("c2集合为："+c2);
		
		/**
		 * boolean addAll(Collection c)                                                                   
		 * 将给定集合的所有元素添加到当前集合中
		 */
		boolean tf =c1.addAll(c2);
		System.out.println(tf);
		System.out.println("c1集合为："+c1);
		
		Collection<String> c3 =new ArrayList<String>();
		c3.add("c++");
		c3.add("c#");
		//判断c2是否全包含c3??
		boolean tf1 =c2.containsAll(c3);
		System.out.println("c2是否包含c3："+tf1);
		//清除子集合元素+-
		c1.removeAll(c2);
		System.out.println(c1);
		
	}

}

