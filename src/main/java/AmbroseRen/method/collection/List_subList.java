package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取List的子集
 *
 */
public class List_subList {

	public static void main(String[] args) {
		List<Integer> list =new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list.get(3));
		System.out.println("sub:"+list.subList(3, 8));
		
		//抽出子集，循环替换子集内容
		List<Integer> sublist =list.subList(3,8);
		for(int i=0;i<sublist.size();i++){
			int in =sublist.get(i)*10;
			sublist.set(i, in);
			//list.set(i, in);
		}
		System.out.println(list);
	
	}

}