package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转集合
 * 使用Arrays，其提供了一个静态方法：asList
 * （只能转为List集合）
 *
 */
public class ArrayToList {

	public static void main(String[] args) {
		String[] array ={"one","two","three","four"};
		List<String> list =Arrays.asList(array);
		System.out.println(list);
		list.set(2,"数组");
		System.out.println(list);
		
		/** 
		 * 不可以直接添加数组元素
		 * 只能扩容
		 */
//		list.add("five");
	//	System.out.println(list);
		
		List<String> list2 =new ArrayList<String>(list);
		System.out.println(list2);
		list2.add("five");
		System.out.println(list2);

	}

}