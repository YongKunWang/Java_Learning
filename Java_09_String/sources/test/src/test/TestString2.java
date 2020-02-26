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
