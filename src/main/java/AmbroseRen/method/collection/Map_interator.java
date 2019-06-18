package AmbroseRen.method.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Map遍历的三种方法：
 * 1.遍历key
 * 2.遍历entry
 * 3.遍历value
*   
* 项目名称：AmbroseRen  
* 类名称：Map_interator  
* 类描述：  
* 创建人：Administrator  
* 创建时间：2018年12月7日 上午11:35:34  
* @version
 */
public class Map_interator {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("语文", 97);
		map.put("数学", 96);
		map.put("英语", 75);
		map.put("物理", 78);
		map.put("化学", 65);
		System.out.println(map);
		
		/**
		 * 遍历key
		 */
		Set<String> keySet =map.keySet();
		for(String key:keySet){
			System.out.println("key="+key);
			System.out.println(key);
		}
		/**
		 * V get（K k）
		 * 获取给定的key速配对应的value值
		 * 无值则返回null
		 */
		int d =map.get("语文");
		System.out.println("语文"+d);
		/**
		 * 遍历value
		 */
		Collection<Integer> value =map.values();
		for(Integer i:value){
			System.out.println(i);
		}
		/**
		 * 获取每一组键址对
		 * 在Map内部，每一组键值对饲用Map磊部类Entry的实例表示的
		 * （Entry是接口，不通过的Map实现类都实现了Entry用于表示一组键值对）
		 * Set<Entry> entrySet(若干Entry实例)将当前Map中
		 * 所有键值对（）存入一个Set集合并返回。
		 */
		Set<Entry<String,Integer>> entrySet =map.entrySet();
		for(Entry<String,Integer> e:entrySet){
			System.out.println(e);
		}
	}
	
}
