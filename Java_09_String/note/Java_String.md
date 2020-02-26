# 字符串

## 简介

```java
package test;

public class TestString1 {

	public static void main(String[] args) {
		//s1 类类型变量
		//字符串一旦初始化就不能被改变
		// s1可以重新赋值，是因为类类型变量的引用变了
		// “abc”是一个对象
		String s1 = "abc";
		s1 = "kk";
		System.out.println(s1);
		/**
		 * s2 和s3的区别：
		 * 	s2在内存中只有一个对象
		 *  s3 在内存中有两个对象：
		 *  	一个String对象
		 *  	一个“abc”对象
		 */
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = "abc";
		
		System.out.println(s2 == s3);  //false 比较地址是否相同
		System.out.println(s2 == s4);  //true 比较地址是否相同
		//重写了方法，用于判定字符串是否相同
		System.out.println(s2.equals(s3));
	}
}


```

## String 方法

```java
/*

String类适用于描述字符串事物。
那么它就提供了多个方法对字符串进行操作。

常见的操作有哪些？
"abcd"

1，获取。
	1.1 字符串中的包含的字符数，也就是字符串的长度。
		int length():获取长度。
	1.2 根据位置获取位置上某个字符。
		char charAt(int index):
	1.3 根据字符获取该字符在字符串中位置。
		int indexOf(int ch):返回的是ch在字符串中第一次出现的位置。
		int indexOf(int ch, int fromIndex) :从fromIndex指定位置开始，获取ch在字符串中出现的位置。

		int indexOf(String str):返回的是str在字符串中第一次出现的位置。
		int indexOf(String str, int fromIndex) :从fromIndex指定位置开始，获取str在字符串中出现的位置。

		int lastIndexOf(int ch) ：

		
2，判断。
	2.1 字符串中是否包含某一个子串。
		boolean contains(str):
		特殊之处：indexOf(str):可以索引str第一次出现位置，如果返回-1.表示该str不在字符串中存在。
				所以，也可以用于对指定判断是否包含。
				if(str.indexOf("aa")!=-1)

				而且该方法即可以判断，有可以获取出现的位置。

	2.2 字符中是否有内容。
		boolean isEmpty(): 原理就是判断长度是否为0. 
	2.3 字符串是否是以指定内容开头。
		boolean startsWith(str);
	2.4 字符串是否是以指定内容结尾。
		boolean endsWith(str);
	2.5 判断字符串内容是否相同。复写了Object类中的equals方法。
		boolean equals(str);
	2.6 判断内容是否相同，并忽略大小写。
		boolean equalsIgnoreCase();
	
3，转换。
	3.1 将字符数组转成字符串。
		构造函数：String(char[])
				  String(char[],offset,count):将字符数组中的一部分转成字符串。

		静态方法：
				static String copyValueOf(char[]);
				static String copyValueOf(char[] data, int offset, int count) 

				static String valueOf(char[]):

		
	3.2 将字符串转成字符数组。**
		char[] toCharArray():

	3.3 将字节数组转成字符串。
			String(byte[])
			String(byte[],offset,count):将字节数组中的一部分转成字符串。

	3.4 将字符串转成字节数组。
			byte[]  getBytes():
	3.5 将基本数据类型转成字符串。
		static String valueOf(int)
		static String valueOf(double)

		//3+"";//String.valueOf(3);

		特殊：字符串和字节数组在转换过程中，是可以指定编码表的。

4，替换
	String replace(oldchar,newchar);

5，切割
	String[] split(regex);

6，子串。获取字符串中的一部分。
	String substring(begin);
	String substring(begin,end);

7，转换，去除空格，比较。
	7.1 将字符串转成大写或则小写。
		 String toUpperCase();
		 String toLowerCase();

	7.2 将字符串两端的多个空格去除。
		String trim();

	7.3 对两个字符串进行自然顺序的比较。
		int compareTo(string);


*/

class  StringMethodDemo
{

	public static void method_7()
	{
		String s = "    Hello Java     ";
		sop(s.toLowerCase());
		sop(s.toUpperCase());
		sop(s.trim());

		String s1 = "a1c";
		String s2 = "aaa";

		sop(s1.compareTo(s2));
	}
	public static void method_sub()
	{
		String s = "abcdef";

		sop(s.substring(2));//从指定位置开始到结尾。如果角标不存在，会出现字符串角标越界异常。
		sop(s.substring(2,4));//包含头，不包含尾。s.substring(0,s.length());
	}

	public static void  method_split()
	{
		String s = "zhagnsa,lisi,wangwu";

		String[] arr  = s.split(",");

		for(int x = 0; x<arr.length; x++)
		{
			sop(arr[x]);
		}
	}

	public static void method_replace()
	{
		String s = "hello java";

		//String s1 = s.replace('q','n');//如果要替换的字符不存在，返回的还是原串。


		String s1 = s.replace("java","world");
		sop("s="+s);
		sop("s1="+s1);
	}

	public static void method_trans()
	{
		char[] arr = {'a','b','c','d','e','f'};

		String s= new String(arr,1,3);

		sop("s="+s);

		String s1 = "zxcvbnm";

		char[] chs = s1.toCharArray();

		for(int x=0; x<chs.length; x++)
		{
			sop("ch="+chs[x]);
		}
	}
	public static void method_is()
	{
		String str = "ArrayDemo.java";
		
		//判断文件名称是否是Array单词开头。
		sop(str.startsWith("Array"));
		//判断文件名称是否是.java的文件。
		sop(str.endsWith(".java"));
		//判断文件中是否包含Demo
		sop(str.contains(".java"));


	}


	public static void method_get()
	{
		String str = "abcdeakpf";

		//长度
		sop(str.length());

		//根据索引获取字符。
		sop(str.charAt(4));//当访问到字符串中不存在的角标时会发生StringIndexOutOfBoundsException。


		//根据字符获取索引
		sop(str.indexOf('m',3));//如果没有找到，返回-1.
		
		//反向索引一个字符出现位置。
		sop(str.lastIndexOf("a"));

		
	}
	public static void main(String[] args) 
	{
		method_7();
//		method_trans();
//		method_is();
//		method_get();
		/*
		String s1 = "abc";
		String s2 = new String("abc");

		String s3 = "abc";
		System.out.println(s1==s2);
		System.out.println(s1==s3);

		*/
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

```

```java
package test;

public class TestString2 {

	public static void main(String[] args) {
//	1. 获取字符串
		String str1 = "qwyertyuiop";
		System.out.println("字符串长度为：" + str1.length());
		System.out.println("字符串在第3位的字符为 ：" + str1.charAt(2));
		System.out.println("字符y在字符串中第一次出现的位置为：" + str1.indexOf('y'));
		System.out.println("字符y在字符串中第一次出现的位置为：" + str1.indexOf('y',3));
	
//	2. 判断字符串
		System.out.println("字符串中是否包含子串：" + str1.contains("ye"));
		System.out.println("字符串中是否包含内容：" + str1.isEmpty());
//	3. 转换
//		字符数组转换为字符串
		char[] arr1 = {'a','b','c','d','e','f','g'};
		String str2 = new String(arr1);
		System.out.println(str2);
		
	
	}

}

```

```java
package test;

/*
1，模拟一个trim方法，去除字符串两端的空格。
	思路：
	1，判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止。
		结尾处判断空格也是如此。
	2，当开始和结尾都判断到不是空格时，就是要获取的字符串。

2，将一个字符串进行反转。将字符串中指定部分进行反转，"abcdefg";abfedcg
	思路：
	1，曾经学习过对数组的元素进行反转。
	2，将字符串变成数组，对数组反转。
	3，将反转后的数组变成字符串。
	4，只要将或反转的部分的开始和结束位置作为参数传递即可。


*/

public class TestString3 {

	public static void sop (String str) {
		System.out.println(str);
	}
//案例1. 删除字符串前后的空格
	public static String myTrim(String str) {
		//前后索引值
		int start = 0; 
		int end = str.length() -1;
		while(start < end && str.charAt(start)== ' ')
			start ++;
		while (start <end && str.charAt(end) == ' ') 
			end --;
//		substring(start,end)
//		start:开始
//		end  :结束(不包括)
		return str.substring(start, end+1);
		//smiles 1,5 mile
		
	}
//	案例2. 字符串反转
//	Hello-World!!  0 4 --> Hello  olleH
	public static String reverseString(String str,int start,int end) {
		//1. 字符串转换为字符串数组
		char[] chs = str.toCharArray();
		//2.进行指定位置的字符串数组反转
		reverse(chs, start, end);
		return new String(chs);
	}
	private static void reverse(char[] chs, int x, int y) {
		for(int start = x, end = y;start <= end;start ++,end --) {
			swap(chs,start,end);
		}
	}
	private static void swap(char[] chs, int x, int y) {
		char temp = chs[x];
		chs[x] = chs[y];
		chs[y] = temp;
	}
	public static void main(String[] args) {
		String str1 = "   Hello World!!   ";
		String str2 = "Hello-World!!";
		sop(myTrim(str1));
		sop(reverseString(str2,0,1));
	}
}
```

## 数据类型

```java
/*
基本数据类型对象包装类。

byte	Byte
short	short
int		Integer
long	Long
boolean Boolean
float	Float
double	Double
char	Character



基本数据类型对象包装类的最常见作用:
就是用于基本数据类型和字符串类型之间做转换

基本数据类型转成字符串。

	基本数据类型+""

	基本数据类型.toString(基本数据类型值);

	如： Integer.toString(34);//将34整数变成"34";


字符串转成基本数据类型。

	xxx a = Xxx.parseXxx(String);

	int a = Integer.parseInt("123");

	double b = Double.parseDouble("12.23");

	boolean b = Boolean.parseBoolean("true");

	Integer i = new Integer("123");

	int num = i.intValue();

	


十进制转成其他进制。
	toBinaryString();
	toHexString();
	toOctalString();


其他进制转成十进制。
	parseInt(string,radix);


*/
class IntegerDemo 
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	
	public static void main(String[] args) 
	{
		//整数类型的最大值。
		//sop("int max :"+Integer.MAX_VALUE);

//		将一个字符串转成整数。

		int num = Integer.parseInt("123");//必须传入数字格式的字符串。
		//long x = Long.parseLong("123");

//		sop("num="+(num+4));

//		sop(Integer.toBinaryString(-6));
//		sop(Integer.toHexString(60));

		int x = Integer.parseInt("3c",16);

		sop("x="+x);
	}
}
```

```java
package test;

/**
 * 1. 基本数据类型包装类的作用：
 * 		就是用于数字转为字符串
 * 		字符串转为数字
 * 2. 数字转换为字符串： 数字+ "" Integer.toString(32);
 * 3. 字符串转换为数字：xxx a = xxx.parse.xxx("xx");
 * 4. 十进制转换为其他进制：
 * 		toBinaryString();
 * 		toOctalString();
 * 		toHexString();
 * 5. 其他进制转换为十进制：
 * 		parseInt("xx",xx);
 * 
 *
 */

public class TestString5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		System.out.println(10 + ' ');
		System.out.println(Integer.toString(a));
		System.out.println(Integer.MAX_VALUE);
		//严格数字
		int b = Integer.parseInt("123");
		System.out.println(b);
		float c = Float.parseFloat("222");
		System.out.println(c);
	}

}

```

## 自动装箱和自动拆箱

```java
/*
JDK1.5版本以后出现的新特性。

*/

class IntegerDemo1 
{
	public static void main(String[] args) 
	{
		
//		Integer x = new Integer(4);

		Integer x = 4;//自动装箱。//new Integer(4)

		x = x/* x.intValue() */ + 2;//x+2:x 进行自动拆箱。变成成了int类型。和2进行加法运算。
					//再将和进行装箱赋给x。

		

		Integer m = 128;
		Integer n = 128;

		sop("m==n:"+(m==n));

		Integer a = 127;
		Integer b = 127;

		sop("a==b:"+(a==b));//结果为true。因为a和b指向了同一个Integer对象。
						//因为当数值在byte范围内容，对于新特性，如果该数值已经存在，则不会在开辟新的空间。
	}

	public static void method()
	{
		Integer x = new Integer("123");

		Integer y = new Integer(123);

		sop("x==y:"+(x==y));
		sop("x.equals(y):"+x.equals(y));
	}

	public static void sop(String str)
	{
		System.out.println(str);
	}
	
}

```

```java
package test;
/**
 * 1. 自动装箱和自动拆箱
 * JDK5.0以后的新特性
 * 2. 是否指向同一个对象
 * 		当范围在byte以内，属于同一个对象
 * @author asdw1
 *
 */
public class TestString6 {

	public static void main(String[] args) {
//		这两种方式是等价的
//		自动装箱！！
		Integer a = new Integer(5);
		Integer b = 5; // 5 是一个实例对象 类型是Integer
//		自动拆箱，不可能一个对象和一个数字进行相加减
		b = b + 5; 
		b = b.intValue() + 5;
		
		Integer n = 125;
		Integer n1 = 125;
		Integer m = 128;
		Integer m1 = 128;
		System.out.println(n == n1); //true
		System.out.println(m == m1); //false
		//当数值范围在byte内容中，对于新特性来说，如果该数值已经存在
		//则不会开辟新空间
		
		Integer x = new Integer("123");
		Integer y = new Integer(123);
		System.out.println(x.equals(y)); //比较内容 true
		

	}

}

```

## StringBuffer和StringBuilder

```java
/*
StringBuffer是字符串缓冲区。

是一个容器。
特点：
1，长度是可变化的。
2，可以字节操作多个数据类型。
3，最终会通过toString方法变成字符串。

C create U update R read D delete

1，存储。
	StringBuffer append():将指定数据作为参数添加到已有数据结尾处。
	StringBuffer insert(index,数据):可以将数据插入到指定index位置。


2，删除。
	StringBuffer delete(start,end):删除缓冲区中的数据，包含start，不包含end。
	StringBuffer deleteCharAt(index):删除指定位置的字符。
	
3，获取。
	char charAt(int index) 
	int indexOf(String str) 
	int lastIndexOf(String str) 
	int length() 
	String substring(int start, int end) 
 
4，修改。
	StringBuffer replace(start,end,string);
	void setCharAt(int index, char ch) ;


5，反转。
	StringBuffer reverse();
 
6，
	将缓冲区中指定数据存储到指定字符数组中。
	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 

	
JDK1.5 版本之后出现了StringBuilder.

StringBuffer是线程同步。
StringBuilder是线程不同步。

以后开发，建议使用StringBuilder

升级三个因素：
1，提高效率。
2，简化书写。
3，提高安全性。

*/
class Demo
{
}

class StringBufferDemo 
{
	public static void main(String[] args) 
	{
		//method_update();

		StringBuilder sb = new StringBuilder("abcdef");
	
		char[] chs = new char[6];


		sb.getChars(1,4,chs,1);//将

		for(int x=0; x<chs.length; x++)
		{
			sop("chs["+x+"]="+chs[x]+";");
		}

		draw(3,6);
		draw(8,9);

//		StringBuilder sb1 = new StringBuilder();
//		sb1.append(new Demo()).append(new Demo());
//		sop("sb1="+sb1);
	}
	public static void method_update()
	{
		StringBuffer sb  = new StringBuffer("abcde");

//		sb.replace(1,4,"java");
		sb.setCharAt(2,'k');


		sop(sb.toString());
	
	}
	public static void method_del()
	{
		StringBuffer sb  = new StringBuffer("abcde");
		
//		sb.delete(1,3);
		//清空缓冲区。
		//sb.delete(0,sb.length());

		//sb.delete(2,3);
		sb.deleteCharAt(2);

		sop(sb.toString());
	}

	public static void method_add()
	{
		StringBuffer sb = new StringBuffer();


		//sb.append("abc").append(true).append(34);
//		StringBuffer sb1 = sb.append(34);
//		sop("sb==sb1:"+(sb==sb1));

		sb.insert(1,"qq");
		sop(sb.toString());//abctrue34
		//sop(sb1.toString());

		
	}

	
	public static void sop(String str)
	{
		System.out.println(str);
	}
	
	public static void draw(int row,int col)
	{
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<row; x++)
		{
			for(int y=0; y<col; y++)
			{
				sb.append("*");
			}
			sb.append("\r\n");
		}

		sop(sb.toString());
	}

}

```

