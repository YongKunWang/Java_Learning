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
