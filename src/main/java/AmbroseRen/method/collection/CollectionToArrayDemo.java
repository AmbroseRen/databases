package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转数组
 * Collection中相关方法：toArray（）
 * 将集合转换为数组
 *
 */
public class CollectionToArrayDemo {

	public static void main(String[] args) {
		Collection<String> c =new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
		String[] arr =c.toArray(new String[c.size()]);
		for(String array:arr){
			System.out.println(array);
		}
	}

}

