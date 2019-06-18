package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 * Collection提供了遍历集合元素的方法：
 * Iterator iterator（）
 * 该方法会返回一个用于遍历当前集合的迭代器
 *  
 * java.util.Iterator
 * 迭代器是一个接口，规定了遍历集合的统一方法。
 * 不同集合实现类都提供了一个迭代器的实现类用于遍历自身。
 * 
 * 使用迭代器遍历集合的步骤：问，取，删（删不是必须的）。
 * @author 天大java
 *
 */
public class Collection_iterator {

	public static void main(String[] args) {
		Collection<String> c =new ArrayList<String>();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println("c=="+c);
		
		Iterator it =c.iterator();
		while(it.hasNext()){
			String str =(String)(it.next());
			System.out.println("遍历c=="+str);
			
			if("#".equals(str)){
				/**
				 * 让迭代器遍历移除next()获取的元素，
				 * 只能通过迭代器提供的方法删除
				 * ！！！不能通过集合的方法
				 */
			//	c.remove(str);
				it.remove();
			}
		}
		System.out.println(c);
	}

}

