package test;

/**
 * 1. �����������Ͱ�װ������ã�
 * 		������������תΪ�ַ���
 * 		�ַ���תΪ����
 * 2. ����ת��Ϊ�ַ����� ����+ "" Integer.toString(32);
 * 3. �ַ���ת��Ϊ���֣�xxx a = xxx.parse.xxx("xx");
 * 4. ʮ����ת��Ϊ�������ƣ�
 * 		toBinaryString();
 * 		toOctalString();
 * 		toHexString();
 * 5. ��������ת��Ϊʮ���ƣ�
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
		//�ϸ�����
		int b = Integer.parseInt("123");
		System.out.println(b);
		float c = Float.parseFloat("222");
		System.out.println(c);
	}

}
