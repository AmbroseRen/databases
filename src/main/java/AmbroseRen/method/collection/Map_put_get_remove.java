package AmbroseRen.method.collection;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * java.util.Map
 * Map称为查找表，一key-value对的形式存放元素
 * 在Map中的要求：key不允许重复（equals)判断
 * 
 * 常用实现类：java.util.HashMap(散列表=哈希表)
 * 			TreeMap 二叉树
 * @author 天大java
 *
 */
public class Map_put_get_remove{

	public static void main(String[] args) {
		Map<String,Integer> map =new HashMap<String,Integer>();
		/**
		 * v put(K k,V v)
		 * 将给定的key-value对存入Map
		 * 由于Map要求key不允许重复，所以使用已有key键就是替换value；
		 * 若key不存在，则值为null
		 */
		map.put("语文", 97);
		map.put("数学", 96);
		map.put("英语", 75);
		map.put("物理", 78);
		map.put("化学", 65);
		System.out.println(map);
		String json =JSONUtils.toJSONString(map);
		System.out.println("json=="+json);
		
		//替换键值
		Integer i =map.put("语文",100);
		System.out.println("key=="+i);
		
		/**
		 * v remove(K k)
		 * 根据给定的key将对应的这组键值对删除
		 * 返回值为对应的value
		 * 若给定的key不存在，则返回null
		 */
		map.remove("物理");
		System.out.println("map=="+map);
	}

}
