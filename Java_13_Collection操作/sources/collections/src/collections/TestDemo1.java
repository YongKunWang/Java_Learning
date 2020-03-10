package collections;

import java.util.*;


/**
 * collections的常用方法
 * 1. colections 为工具类
 * 2. collections和collection的区别：
 * 		collection 是集合框架的顶层设计接口，定义了集合操作的共性方法
 * 		collections是集合框架的一个工具类
 * 3. 主要方法：
 * 		BinarySearch
 * 		sort
 * 		max 
 * 		按照指定比较方式寻找最大和排序
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		searchDemo();
		maxDemo();
		sortDemo();
	}
	
	public static void searchDemo() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("bb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eeee");
		arr.add("fffff");
		arr.add("gggggg");
		sop(arr);
		sop(Collections.binarySearch(arr, "ccc"));
		sop(halfSearch(arr,"cccc"));
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
	
	public static  int halfSearch(List<String> list,String key) {
		int min = 0;
		int max = list.size() - 1;
		int mid;
		while(min <= max) {
			mid = (max + min)/2;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if(num > 0)
				max = mid - 1;
			else if(num < 0)
				min = min + 1;
			else 
				return mid;
		}
		
		return - min -1;
	}
	public static void maxDemo() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("bb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eeee");
		arr.add("fffff");
		arr.add("gggggg");
		arr.add("z");
		sop(arr);
		sop(Collections.max(arr,new MyMaxImpl()));
	}
	public static void sortDemo() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("bb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eeee");
		arr.add("fffff");
		arr.add("gggggg");
		arr.add("z");
		sop(arr);
		Collections.sort(arr,new MyMaxImpl());
		sop(arr);
	}
}
class MyMaxImpl implements Comparator<String> {
	public int compare(String s1,String s2) {
		if(s1.length()>s2.length())
			return 1;
		if(s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);
	}
}
