package test;

public class TestString1 {

	public static void main(String[] args) {
		//s1 �����ͱ���
		//�ַ���һ����ʼ���Ͳ��ܱ��ı�
		// s1�������¸�ֵ������Ϊ�����ͱ��������ñ���
		// ��abc����һ������
		String s1 = "abc";
		s1 = "kk";
		System.out.println(s1);
		/**
		 * s2 ��s3������
		 * 	s2���ڴ���ֻ��һ������
		 *  s3 ���ڴ�������������
		 *  	һ��String����
		 *  	һ����abc������
		 */
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = "abc";
		
		System.out.println(s2 == s3);  //false �Ƚϵ�ַ�Ƿ���ͬ
		System.out.println(s2 == s4);  //true �Ƚϵ�ַ�Ƿ���ͬ
		//��д�˷����������ж��ַ����Ƿ���ͬ
		System.out.println(s2.equals(s3));

	}

}
