package collections;
/**
 * �ɱ������
 * 1. �������
 * 2. ʹ��������Ϊ�βδ��ݶ������
 * 3. ����д�ĸ�ʽ���ݶ������
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
		//����д�ķ���
		show1(1,2,3,4,5,6,7,1,8,9);

	}
	//���صķ���
	public static void show(int a) {
		System.out.println(a);
	}
	public static void show(int a,int b) {
		System.out.println(a+"+"+b);
	}
	public static void show(int a,int b, int c) {
		System.out.println(a+"+"+b+"+"+c);
	}
	
	//�����βεķ���
	public static void show(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}
	//�ɱ����
	public static void show1(int... a) { 
		for (int i : a) {
			System.out.println(i);
		}

	}
	//������������ǰ��
	//�ɱ�����������
	public static void show1(String s,int... a) { 
		System.out.println(s);
		for (int i : a) {
			System.out.println(i);
		}

	}
	//�����βεķ�ʽ�Ϳɱ�����ķ����޷��������أ�˵������Ϊͬһ�ַ���
}
