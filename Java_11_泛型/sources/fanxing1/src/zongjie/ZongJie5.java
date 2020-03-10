package zongjie;


/**
 * 泛型类 泛型接口 泛型方法
 * 在同一个泛型类中，实现不同参数类型的显示(泛型方法)
 * 泛型方法的<T>在权限修饰符和返回值的中间
 * @author asdw1
 *
 */

interface Inter <T>{
	void show(T t);
}
//实现类明确参数类型
class InterImpl1 implements Inter<String> {
	public void show(String string) {
		System.out.println(string);
	}
}
//实现类未明确参数类型
class InterImpl2 <T> implements Inter<T> {
	public void show(T t) {
		System.out.println(t);
	}
	public <T> void dispaly(T t) {
		System.out.println("泛型方法： " + t);
	}
}
public class ZongJie5 {

	public static void main(String[] args) {
		InterImpl1 in1 = new InterImpl1();
		in1.show("实现类明确参数类型的泛型接口...");
		InterImpl2 in2 = new InterImpl2();
		in2.show("实现类未明确参数类型的泛型接口...");
		InterImpl2 in3 = new InterImpl2();
		in3.show(2);
		InterImpl2<Integer> in4 = new InterImpl2();
		in4.show(new Integer(5));
		in4.dispaly("String");
	}

}
