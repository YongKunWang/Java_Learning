package test;
/**
 * 1. �Զ�װ����Զ�����
 * JDK5.0�Ժ��������
 * 2. �Ƿ�ָ��ͬһ������
 * 		����Χ��byte���ڣ�����ͬһ������
 * @author asdw1
 *
 */
public class TestString6 {

	public static void main(String[] args) {
//		�����ַ�ʽ�ǵȼ۵�
//		�Զ�װ�䣡��
		Integer a = new Integer(5);
		Integer b = 5; // 5 ��һ��ʵ������ ������Integer
//		�Զ����䣬������һ�������һ�����ֽ�����Ӽ�
		b = b + 5; 
		b = b.intValue() + 5;
		
		Integer n = 125;
		Integer n1 = 125;
		Integer m = 128;
		Integer m1 = 128;
		System.out.println(n == n1); //true
		System.out.println(m == m1); //false
		//����ֵ��Χ��byte�����У�������������˵���������ֵ�Ѿ�����
		//�򲻻Ὺ���¿ռ�
		
		Integer x = new Integer("123");
		Integer y = new Integer(123);
		System.out.println(x.equals(y)); //�Ƚ����� true
		

	}

}
