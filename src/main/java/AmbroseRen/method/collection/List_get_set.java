package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * java.util.List
 * List集合是可重复集，且有序
 * 提供了一套可以通过下标操作元素的方法
 *
 */
public class List_get_set {
	public static void main(String[] args) {
//		List list =new LinkList();
		List<String> list =new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		Map<String,Integer> map =new HashMap<String,Integer>();
		map.put("语文", 97);
		map.put("数学", 96);
		map.put("英语", 75);
		map.put("物理", 78);
		map.put("化学", 65);
		list.add(JSONUtils.toJSONString(map));
		System.out.println(list);
		
		/**
		 * E get(int index)
		 * 获取给定下标处对应的元素array[i]
		 */
		//获取第二个元素
		String str =list.get(1);
		System.out.println("第二个元素为："+str);
		
		for(int i=0;i<list.size();i++){
			str =list.get(i);
			System.out.println(str);
		}
		
		//替换元素方法： .set(int i,E e)
		String s1 =list.set(2,"三");
		System.out.println(list);
		System.out.println(s1);
		
		//插入元素到指定位置
		list.add(2,"分割线");
		System.out.println(list);
	}
}

