package learning;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Map 的常用操作
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		// put添加相同键的元素，会返回覆盖前的元素
		map.put("01", "Java01");
		map.put("02", "Java02");
		map.put("03", "Java03");
		map.put("04", "Java04");
		map.put("05", "Java05");
		System.out.println("containsKey: " + map.containsKey("01"));
		System.out.println("ContainsValue: " + map.containsValue("Java01"));
		
		System.out.println("get: " + map.get("04"));
		
		//获取集合中的所有元素：
		
		Collection<String> coll = map.values();
		System.out.println(coll);
		System.out.println(map);
		
		/**
		 * 获取Map集合的2种方法：
		 * 1.获取单列键集合
		 * 2.使用iterator的方法遍历该set集合
		 * 3.使用map的get方法得到所有的值
		 */
		Set<String> keySet = map.keySet();
		
		for(Iterator<String> it = keySet.iterator(); it.hasNext();) {
			String key = it.next();
			String value = map.get(key);
			
			System.out.println(key + " = " + value);
		}
		/**
		 * 获取Map集合的第二种方法：
		 * 1. 使用set集合存储Map的键值关系
		 * 2. 使用iterator遍历set集合键值关系
		 * 3. 把键值关系进行分解
		 */
		Set<Map.Entry<String, String>> entries = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entries.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + " = " + value);
		}
		
	}

}
/**
 * Map.Entry其实也是一个接口 是一个内部接口
 * Interface Map {
 * 		public static Interface Entry{
 * 			public abstract Object getKey();
 * 			public abstract Object getValue();
 * 		}
 * }
 * 
 * class HashMap implements Map{
 * 
 * 		class Hass implements Map.Entry{
 * 			public abstract Object getKey(){}
 * 			public abstract Object getValue(){}
 * 		}
 * 
 * }
 * 
 */


