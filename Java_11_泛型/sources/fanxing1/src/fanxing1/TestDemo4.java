package fanxing1;
/**
 * 1. ���巺����
 * 		����֮���������������������ͱ���һ��
 * 2. �����Ҫ���ݲ�һ�£����巺�ͷ���
 * 3. ��̬��������ʹ�÷����࣬��Ϊ���������ڴ�������ʱ����
 * 		��̬��������ʹ�÷��ͷ���
 * @author asdw1
 *
 */

class Demo1<T>{
	public void show(T t) {
		System.out.println(t);
	}
	public void print(T t) {
		System.out.println(t);
	}
}

class Demo2<T>{
	public void show(T t) {
		System.out.println(t);
	}
	public <T> void print(T t) {
		System.out.println(t);
	}
}
class Demo3<T>{
	public void show(T t) {
		System.out.println(t);
	}
	public static <T> void print(T t) {
		System.out.println(t);
	}
}

public class TestDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1<String> demo1 = new Demo1<String>();
		demo1.show("111");
		demo1.print("fde");
		
		Demo2<String> demo2 = new Demo2<String>();
		demo2.show("111");
		demo2.print("fde");
		demo2.print(1);
		demo2.print(new Integer(5));
		
		Demo3.print("1111");
		Demo3.print(111);
	}

}
