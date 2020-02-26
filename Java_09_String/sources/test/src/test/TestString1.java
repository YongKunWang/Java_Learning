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
