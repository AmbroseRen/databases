package AmbroseRen.method.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 各种集合的遍历
*   
* 项目名称：AmbroseRen  
* 类名称：Collections  
* 类描述：  
* 创建人：rensi  
* 创建时间：2018年11月8日 上午11:43:54  
* @version
 */
public class Maps {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("语文", 97);
		map.put("数学", 96);
		map.put("英语", 75);
		map.put("物理", 78);
		map.put("化学", 65);
		System.out.println(map);
		
		/**
		 * 遍历所有key
		 */
		Set<String> keySet =map.keySet();
		for(String key:keySet){
			System.out.println("key="+key);
		}
		/**
		 * 获取指定key对应的value值
		 */
		int d =map.get("语文");
		System.out.println("语文00："+d);
		/**
		 * 获取每一组键址对
		 * 在Map内部，每一组键值对饲用Map磊部类Entry的实例表示的
		 * （Entry是接口，不通过的Map实现类都实现了Entry用于表示一组键值对）
		 * Set<Entry> entrySet(若干Entry实例)将当前Map中
		 * 所有键值对（）存入一个Set集合并返回。
		 */
		Set<Entry<String,Integer>> entrySet =map.entrySet();
		for(Entry<String,Integer> e:entrySet){
			System.out.println(e.getKey()+"："+e.getValue());
		}
		/**
		 * 遍历所有value
		 * Collection<v> values
		 * 将当前Map中所有value存入一个集合后返回
		 */
		Collection<Integer> value =map.values();
		for(Integer i:value){
			System.out.println("value="+i);
		}
	}
	
	public static String map(Map<String, Integer> map){
		 map = new HashMap<String,Integer>();
		return "";
	}
}
