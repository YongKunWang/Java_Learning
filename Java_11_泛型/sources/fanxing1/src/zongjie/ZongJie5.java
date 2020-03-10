package zongjie;


/**
 * ������ ���ͽӿ� ���ͷ���
 * ��ͬһ���������У�ʵ�ֲ�ͬ�������͵���ʾ(���ͷ���)
 * ���ͷ�����<T>��Ȩ�����η��ͷ���ֵ���м�
 * @author asdw1
 *
 */

interface Inter <T>{
	void show(T t);
}
//ʵ������ȷ��������
class InterImpl1 implements Inter<String> {
	public void show(String string) {
		System.out.println(string);
	}
}
//ʵ����δ��ȷ��������
class InterImpl2 <T> implements Inter<T> {
	public void show(T t) {
		System.out.println(t);
	}
	public <T> void dispaly(T t) {
		System.out.println("���ͷ����� " + t);
	}
}
public class ZongJie5 {

	public static void main(String[] args) {
		InterImpl1 in1 = new InterImpl1();
		in1.show("ʵ������ȷ�������͵ķ��ͽӿ�...");
		InterImpl2 in2 = new InterImpl2();
		in2.show("ʵ����δ��ȷ�������͵ķ��ͽӿ�...");
		InterImpl2 in3 = new InterImpl2();
		in3.show(2);
		InterImpl2<Integer> in4 = new InterImpl2();
		in4.show(new Integer(5));
		in4.dispaly("String");
	}

}
