# Collection集合的操作方法

## collections

```java
/*
集合框架的工具类。
Collections:集合框架的工具类。里面定义的都是静态方法。

Collections和Collection有什么区别？
Collection是集合框架中的一个顶层接口，它里面定义了单列集合的共性方法。
		它有两个常用的子接口，
		List：对元素都有定义索引。有序的。可以重复元素。
		Set：不可以重复元素。无序。

Collections是集合框架中的一个工具类。该类中的方法都是静态的
		提供的方法中有可以对list集合进行排序，二分查找等方法。
		通常常用的集合都是线程不安全的。因为要提高效率。
		如果多线程操作这些集合时，可以通过该工具类中的同步方法，将线程不安全的集合，转换成安全的。




*/
import java.util.*;
class  CollectionsDemo
{
	public static void main(String[] args) 
	{
		sortDemo();

	}



	public static void binarySearchDemo()
	{
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		Collections.sort(list,new StrLenComparator());

		sop(list);

		//int index = Collections.binarySearch(list,"aaaa");
		//int index = halfSearch(list,"cc");
		int index = halfSearch2(list,"aaaa",new StrLenComparator());
		sop("index="+index);
	}

	public static int halfSearch(List<String> list,String key)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;

		while(min<=max)
		{
			mid = (max+min)>>1;//  /2;

			String str = list.get(mid);

			int num = str.compareTo(key);
			if(num>0)
				max = mid -1;
			else if(num<0)
				min = mid + 1;
			else
				return mid;
		}
		return -min-1;
	}

	public static int halfSearch2(List<String> list,String key,Comparator<String> cmp)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;

		while(min<=max)
		{
			mid = (max+min)>>1;//  /2;

			String str = list.get(mid);

			int num = cmp.compare(str,key);
			if(num>0)
				max = mid -1;
			else if(num<0)
				min = mid + 1;
			else
				return mid;
		}
		return -min-1;
	}

	public static void maxDemo()
	{
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		Collections.sort(list);
		sop(list);
		String max = Collections.max(list/*,new StrLenComparator()*/);
		sop("max="+max);
	}

	public static void sortDemo()
	{
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		
		sop(list);

		//Collections.sort(list);
		Collections.sort(list,new StrLenComparator());
		//Collections.swap(list,1,2);
		sop(list);
		
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}


class StrLenComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if(s1.length()>s2.length())
			return 1;
		if(s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);
	}
}
/*
class Student
{
}
list.add(new Student());

public static <T extends Comparable<? super T>> void sort(List<T> list)
{
	
}
*/
```

```java
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

```

```java
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

```

## 数组变为集合

```java
/*
Arrays:用于操作数组的工具类。
里面都是静态方法。


asList:将数组变成list集合
*/

import java.util.*;
class  ArraysDemo
{
	public static void main(String[] args) 
	{
//		int[] arr = {2,4,5};
//
//		System.out.println(Arrays.toString(arr));



		String[] arr = {"abc","cc","kkkk"};


		//把数组变成list集合有什么好处？
		/*
		可以使用集合的思想和方法来操作数组中的元素。

		注意：将数组变成集合，不可以使用集合的增删方法。
		因为数组的长度是固定。
		contains。
		get
		indexOf()
		subList();

		如果你增删。那么会反生UnsupportedOperationException,

		*/
		List<String> list = Arrays.asList(arr);
		//sop("contains:"+list.contains("cc"));
		//list.add("qq");//UnsupportedOperationException,

		//sop(list);

		//int[] nums = {2,4,5};
		Integer[] nums = {2,4,5};

		
		List<Integer> li = Arrays.asList(nums);



		/*
		如果数组中的元素都是对象。那么变成集合时，数组中的元素就直接转成集合中的元素。
		如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的元素存在。
		*/
		sop(li);



	}
	public static boolean myContains(String[] arr,String key)
	{
		for(int x=0;x<arr.length; x++)
		{
			if(arr[x].equals(key))
				return true;
		}
		return false;
	}
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

```

```java
package collections;


import java.util.*;

/**
 * 数组元素变为集合元素的优点：
 * 	方便进行查询操作
 * 	无法进行元素的增删操作
 * @author asdw1
 *
 */
public class TestDemo4 {

	public static void main(String[] args) {
		String[] str = {"111","222","333"};
		List<String> list = Arrays.asList(str);
		System.out.println(list);
		
		int[] in = {111,222,333};
		List<int[]> list2 = Arrays.asList(in);
		System.out.println(list2);
		
		Integer[] in1 = {111,222,333};
		List<Integer> list3 = Arrays.asList(in1);
		System.out.println(list3);
		
		/*
		 * 如果数组中元素为引用类型，那么变成集合时，数组中的元素就直接转换为集合中的元素
		 * 如果数组中的元素都是基本数据类型，那么会将该数组变为集合中的元素存在
		 * */
	}

}

```

## 集合变为数组

```java
/*
集合变数组。
Collection接口中的toArray方法。


*/
import java.util.*;
class  CollectionToArray
{
	public static void main(String[] args) 
	{
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		
		/*
		1,指定类型的数组到底要定义多长呢？
		当指定类型的数组长度小于了集合的size，那么该方法内部会创建一个新的数组。长度为集合的size。
		当指定类型的数组长度大于了集合的size，就不会新创建了数组。而是使用传递进来的数组。
		所以创建一个刚刚好的数组最优。
		

		2,为什么要将集合变数组？
		为了限定对元素的操作。不需要进行增删了。

		*/

		String[] arr = al.toArray(new String[al.size()]);

		System.out.println(Arrays.toString(arr));



	}
}

```

```java
package collections;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合变为数组
 * 1. 集合为什要变为数组？
 * 		为了对数据元素进行限定，无法进行数组元素的增删操作
 * 2. 指定类型的数组的长度为多少？
 * 		当指定类型的数组元素 < 集合的size时，该方法内部会创建一个新的数组，
 * 		长度为集合的size()
 * 		当指定类型的数组元素 > 集合的size时，就不会创建新的数组了，
 * 		而是使用传递进来的数组，且数组的多余元素为null
 * 
 * @author asdw1
 *
 */
public class TestDemo3 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Java01");
		arr.add("Java02");
		arr.add("Java03");
		
		
		String[] str = arr.toArray(new String[arr.size()]);
		System.out.println(str);
		for (String string : str) {
			System.out.println(string);
		}
	}

}

```

## foreach循环

```java
/*
高级for循环

格式：
for(数据类型 变量名 : 被遍历的集合(Collection)或者数组)
{
	
}

对集合进行遍历。
只能获取集合元素。但是不能对集合进行操作。

迭代器除了遍历，还可以进行remove集合中元素的动作。
如果是用ListIterator，还可以在遍历过程中对集合进行增删改查的动作。

传统for和高级for有什么区别呢？

高级for有一个局限性。必须有被遍历的目标。

建议在遍历数组的时候，还是希望是用传统for。因为传统for可以定义脚标。


*/

import java.util.*;

class ForEachDemo 
{
	public static void main(String[] args) 
	{

		
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");


		for(String s : al)
		{
			//s = "kk";
			System.out.println(s);
		}

		System.out.println(al);
		/*
		Iterator<String> it = al.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/

		int[] arr = {3,5,1};

		for(int x=0; x<arr.length; x++)
		{
			System.out.println(arr[x]);
		}
		for(int i : arr)
		{
			System.out.println("i:"+i);
		}


		HashMap<Integer,String> hm = new HashMap<Integer,String>();

		hm.put(1,"a");
		hm.put(2,"b");
		hm.put(3,"c");

		Set<Integer> keySet = hm.keySet();
		for(Integer i : keySet)
		{
			System.out.println(i+"::"+hm.get(i));
		}

//		Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
//		for(Map.Entry<Integer,String> me : entrySet)

		for(Map.Entry<Integer,String> me : hm.entrySet())
		{
			System.out.println(me.getKey()+"------"+me.getValue());
		}

	}
}

```

## 可变参数

```java
package collections;
/**
 * 可变参数：
 * 1. 多个参数
 * 2. 使用数组作为形参传递多个参数
 * 3. 简化书写的格式传递多个参数
 * @author asdw1
 *
 */
public class TestDemo5 {

	public static void main(String[] args) {
		show(1);
		show(1,2);
		show(1,2,3);
		int[] a = {1,2,3,4,5};
		show(a);
		//简化书写的方法
		show1(1,2,3,4,5,6,7,1,8,9);

	}
	//重载的方法
	public static void show(int a) {
		System.out.println(a);
	}
	public static void show(int a,int b) {
		System.out.println(a+"+"+b);
	}
	public static void show(int a,int b, int c) {
		System.out.println(a+"+"+b+"+"+c);
	}
	
	//数组形参的方法
	public static void show(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}
	//可变参数
	public static void show1(int... a) { 
		for (int i : a) {
			System.out.println(i);
		}

	}
	//定长参数在最前面
	//可变参数在最后面
	public static void show1(String s,int... a) { 
		System.out.println(s);
		for (int i : a) {
			System.out.println(i);
		}

	}
	//数组形参的方式和可变参数的方法无法进行重载，说明两者为同一种方法
}

```

## 静态导入

```java

/*
StaticImport  静态导入。

当类名重名时，需要指定具体的包名。
当方法重名是，指定具备所属的对象或者类。
*/

import java.util.*;
import static  java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员。
import static java.util.Collections.*;
/*
packa/Demo.class 
packb/Demo.class

import packa.*;
import packb.*;
*/

import static  java.lang.System.*;//导入了System类中所有静态成员。

class  StaticImport //extends Object
{
	public static void main(String[] args) 
	{

		out.println("haha");
		int[] arr = {3,1,5};

		sort(arr);
		int index = binarySearch(arr,1);
		out.println(Arrays.toString(arr));
		System.out.println("Index="+index);

		ArrayList al = new ArrayList();
		al.add(1);
		al.add(3);
		al.add(2);

		out.println(al);

		sort(al);
		out.println(al);
	}
}

```

```JAVA
package collections;
/**
 * 当类名重名时，需要指定具体的包名。
	当方法重名是，指定具备所属的对象或者类。
 */
import java.util.*;
import static java.util.Arrays.*;

/**
 * 静态导入
 * @author asdw1
 *
 */
public class TestDemo6 {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		//必须增加，因为在Object中有这个方法
		System.out.println(Arrays.toString(arr));
		
	}

}

```



