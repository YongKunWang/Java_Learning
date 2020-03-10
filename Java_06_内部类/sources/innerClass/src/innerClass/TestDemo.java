package innerClass;

/***
 * 外部类访问内部类，必须建立内部类的对象
 * 内部类访问外部类，可以直接访问
 * @author asdw1
 */


public class TestDemo {
	public static void main(String[] args) {
		
		Outer.Inner inner = new Outer.Inner();
		inner.show();
		
		
	}
}
