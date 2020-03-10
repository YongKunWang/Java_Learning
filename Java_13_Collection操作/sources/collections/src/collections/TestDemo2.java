package collections;

import java.util.*;


public class TestDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shuffleDemo(); //随机排序
		OrderDemo();  //可以实现比较器的直接反转
		replaceAllDemo(); // 实现字符串的替换过程
	}
	public static void shuffleDemo() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("bb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eeee");
		arr.add("fffff");
		arr.add("gggggg");
		sop(arr);
		Collections.shuffle(arr);
		sop(arr);
	}
	public static void OrderDemo() {
//		TreeSet<String> tr = new TreeSet<String>(Collections.reverseOrder());
		TreeSet<String> tr = new TreeSet<String>(Collections.reverseOrder(new MyOrderImpl()));
		tr.add("aaabbb");
		tr.add("cs");
		tr.add("rrr");
		tr.add("ttttttt");
		Iterator it = tr.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public static void sop(Object obj) {
		System.out.println(obj);
	}
	
	public static void replaceAllDemo() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("bb");
		arr.add("ccc");
		arr.add("ddd");
		arr.add("eeee");
		arr.add("fffff");
		arr.add("gggggg");
		sop(arr);
		Collections.replaceAll(arr, "eeee", "hhhh");
		sop(arr);
	}

}

class MyOrderImpl implements Comparator<String>{
	public int compare(String s1, String s2) {
		if(s1.length() > s2.length())
			return 1;
		else if(s1.length() < s2.length())
			return -1;
		else 
			return s1.compareTo(s2);
		}
}
