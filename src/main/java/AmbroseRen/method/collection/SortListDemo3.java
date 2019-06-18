package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
	public static void main(String[] args) {
		List<String> list =new ArrayList<String>();
		list.add("苹果");
		list.add("梨子");
		list.add("香蕉");
		System.out.println(list);
		
		/**
		 * Collections提供了一个重载的sort（）方法，
		 * static void sort（List，Comoparator）
		 * 重构比较仪（自定义规则） 进行排序（不要求必须实现Comparable接口，因为是重构的规则）
		 */
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1,String o2){
				return o1.length()-o2.length();
			}
		});
		Collections.sort(list);
		System.out.println(list);
	}
}
