package AmbroseRen.network.Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *将集合或Map转换为线程安全的
 *
 */
public class SyncApi {
	public static void main(String[] args) {
		/**
		 * ArrayList，LinkList都不是线程安全的
		 */
		List<String> list =new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add(1, "1.1");
//		list.clear();
		System.out.println(list);
		
		/**
		 * 将给定集合转为线程安全的
		 */
		list =Collections.synchronizedList(list);
		
		/**
		 * 将给定的集合转换为线程安全的
		 */
		Set<String> set =new HashSet<String>();
		set =Collections.synchronizedSet(set);
		System.out.println("Set集合:"+set);
		
		/**
		 * HashMap也不是线程安全的
		 */
		Map<String,Integer> map =new HashMap<String,Integer>();
//		将给定的Map转换为线程安全的
		map =Collections.synchronizedMap(map);
		
		/**
		 * 线程安全的集合也不与迭代器遍历该集合的操作互斥。
		 * 但迭代器要求遍历的过程中不能通过集合的方法增删元素，否则会抛异常，
		 * 需要自行维护遍历集合与集合元素操作间的互斥关系。
		 */
	}
}
