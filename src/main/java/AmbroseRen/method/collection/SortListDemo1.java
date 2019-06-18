package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 排序集合
 * 使用的工具类：java.util.Collections
 * 方法：sort(),（只能）对集合List进行自然排序
 * @author 天大java
 *
 */
public class SortListDemo1 {

	public static void main(String[] args) {
		List<Integer> list =new ArrayList<Integer>();
		Random random =new Random();
		for(int i=0;i<10;i++){
			//add一个个加
			list.add(random.nextInt(100));
		}
		Collections.sort(list);
		System.out.println(list);
	}

}
