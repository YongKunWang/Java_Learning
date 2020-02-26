package collect;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet的用法
 * 	1. 为什么.add方法返回的值是boolean型？
 * 		是为了判定是否存入了集合中
 * 	2. HashSet如何判断重复元素？
 * 		2.1 通过判断哈希值来来判断是否还有重复值
 * 			元素的存储方法是按照哈希值的大小从上到下进行排序的
 * 			可能与存入集合的顺序不一致
 * 		2.2 当哈希值一样是，通过判断对象是否一样来判断石佛市同一个对象（equals）
 * 		2.3 当哈希值一致时，且对象不一致是，会在后面进行顺延
 * 
 * @author asdw1
 *
 */

public class TestCollection5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet ha = new HashSet();
		System.out.println(ha.add("Java01"));
		System.out.println(ha.add("Java01"));
		ha.add("Java02");
		ha.add("Java03");
		ha.add("Java04");
		ha.add("Java04");
		
		Iterator it = ha.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
