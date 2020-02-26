package collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList 的用法：
 * 	1. 简单的增删改查
 * 
 * @author asdw1
 *
 */

public class TestCollection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method2();
		
	}
	
	public static void method1() {
		ArrayList arr1 = new ArrayList();
		//1.1增加
		arr1.add("Java01");
		arr1.add("Java02");
		arr1.add("Java03");
		arr1.add("Java04");
		arr1.add("Java05");
		//1.2添加
		arr1.add(1,"Java09");
		
		//1.3删除
		arr1.remove(2);
		//1.4修改
		arr1.set(4, "Java05");
		//1.5 通过角标获取元素
		System.out.println(arr1.get(4));
		
		//1.6 获取所有元素
		for(int i = 0; i < arr1.size(); i++){
			System.out.println(arr1.get(i));
		}
		//1.7使用迭代器获取元素
		Iterator it = arr1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//1.8 获取对象位置
		System.out.println("index = " + arr1.indexOf("Java09"));
	}
	
	public static void method2() {
		
		ArrayList arr1 = new ArrayList();
		//1.1增加
		arr1.add("Java01");
		arr1.add("Java02");
		arr1.add("Java03");
		arr1.add("Java04");
		arr1.add("Java05");
		
		//2 迭代器的局限性
		/**
		 * java.util.ConcurrentModificationException
		 * 当不允许这样的修改时，可以通过检测到对象的并发修改的方法来抛出此异常。 
		 * 例如，一个线程通常不允许修改集合，而另一个线程正在遍历它。 
		 * 一般来说，在这种情况下，迭代的结果是未定义的。 
		 * 某些迭代器实现（包括由JRE提供的所有通用集合实现的实现）
		 * 可能会选择在检测到此行为时抛出此异常。  
		 */
		Iterator it = arr1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			//error 
			//简单来说，就是迭代器在迭代之前就已经确认了集合中的元素了
			//你现在增减元素，属于多线程操作
			//你可以实现移除操作！！，这属于同线程操作！！
			//arr1.add(1,"Java06");
			
		}
		//List元素的特有迭代器
		//因为带有角标！！
		ListIterator lit = arr1.listIterator();
		while(lit.hasNext()) {
			
			Object object = lit.next();
			if(object.equals("Java02")) {
				lit.set("Java03");
			}
		}
		
		System.out.println(arr1);
	}

}
