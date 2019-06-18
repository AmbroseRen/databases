package AmbroseRen.method.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型在集合中的应用
 * 泛型用来规定集合中元素的类型
 * @author 天大java
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection<String> c =new ArrayList<String>();
		c.add("我很帅");
		c.add("你很乖");
		c.add("滴答");
		c.add("滴答");
		System.out.println(c);
		
		Iterator<String> it =c.iterator();
		while(it.hasNext()){
			String str =it.next();
		}
		
		for(String str:c){
			System.out.println(str);
		}
		
	}
}

