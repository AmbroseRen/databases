package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用新循环遍历集合
 * @author 天大java
 *
 */
public class NewForDemo2 {

	public static void main(String[] args) {
		Collection c =new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		System.out.println(c);
		
		/**
		 * 新循环只是编译器认可，而不是虚拟机认可
		 * 编译器编译时会改为使用迭代器遍历
		 * （不能用集合方法修改元素）
		 */
		for(Object o:c){
			System.out.println(o);
			String str =(String)o;
			System.out.println(str);
		}

	}

}

