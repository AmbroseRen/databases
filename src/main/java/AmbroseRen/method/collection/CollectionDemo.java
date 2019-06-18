package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection
 * 集合
 * 用来存放一组元素，与数组功能相似。
 * 集合提供了操作元素的相关方法
 * 集合常见的两个子接口：
 * Sgt：不可重复集，重复元素不能放入
 * List：可重复集
 * equals()判定是否重复
 * 
 */
public class CollectionDemo {

	public static void main(String[] args) {
		Collection<String> c =new ArrayList<String>();
		/**
		 * boolean add(E e)
		 * 向当前集合添加给定元素，若成功存入则返回true
		 */
		c.add("fasfdsafa");
		c.add("fdsagfq");
		c.add("fjwjfpoiqjhgq");
		System.out.println(c);
		
		//.size()得到集合的长度
		int size =c.size();
		System.out.println(size);
		
		//.isEnpty()判断集合不含有任何元素
		boolean isEnpty =c.isEmpty();
		System.out.println("是否空集："+isEnpty);
		
		//void clear()清空集合
		c.clear();
		System.out.println(c);
		
	}

}
