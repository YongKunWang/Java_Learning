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
