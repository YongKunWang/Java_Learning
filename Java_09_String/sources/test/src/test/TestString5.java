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
