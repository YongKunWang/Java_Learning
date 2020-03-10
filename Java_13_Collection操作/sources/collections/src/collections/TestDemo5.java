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
