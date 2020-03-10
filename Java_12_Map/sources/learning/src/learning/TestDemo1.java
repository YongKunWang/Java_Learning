package learning;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Map �ĳ��ò���
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		// put�����ͬ����Ԫ�أ��᷵�ظ���ǰ��Ԫ��
		map.put("01", "Java01");
		map.put("02", "Java02");
		map.put("03", "Java03");
		map.put("04", "Java04");
		map.put("05", "Java05");
		System.out.println("containsKey: " + map.containsKey("01"));
		System.out.println("ContainsValue: " + map.containsValue("Java01"));
		
		System.out.println("get: " + map.get("04"));
		
		//��ȡ�����е�����Ԫ�أ�
		
		Collection<String> coll = map.values();
		System.out.println(coll);
		System.out.println(map);
		
		/**
		 * ��ȡMap���ϵ�2�ַ�����
		 * 1.��ȡ���м�����
		 * 2.ʹ��iterator�ķ���������set����
		 * 3.ʹ��map��get�����õ����е�ֵ
		 */
		Set<String> keySet = map.keySet();
		
		for(Iterator<String> it = keySet.iterator(); it.hasNext();) {
			String key = it.next();
			String value = map.get(key);
			
			System.out.println(key + " = " + value);
		}
		/**
		 * ��ȡMap���ϵĵڶ��ַ�����
		 * 1. ʹ��set���ϴ洢Map�ļ�ֵ��ϵ
		 * 2. ʹ��iterator����set���ϼ�ֵ��ϵ
		 * 3. �Ѽ�ֵ��ϵ���зֽ�
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
 * Map.Entry��ʵҲ��һ���ӿ� ��һ���ڲ��ӿ�
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


