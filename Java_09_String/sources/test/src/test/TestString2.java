package test;

public class TestString2 {

	public static void main(String[] args) {
//	1. ��ȡ�ַ���
		String str1 = "qwyertyuiop";
		System.out.println("�ַ�������Ϊ��" + str1.length());
		System.out.println("�ַ����ڵ�3λ���ַ�Ϊ ��" + str1.charAt(2));
		System.out.println("�ַ�y���ַ����е�һ�γ��ֵ�λ��Ϊ��" + str1.indexOf('y'));
		System.out.println("�ַ�y���ַ����е�һ�γ��ֵ�λ��Ϊ��" + str1.indexOf('y',3));
	
//	2. �ж��ַ���
		System.out.println("�ַ������Ƿ�����Ӵ���" + str1.contains("ye"));
		System.out.println("�ַ������Ƿ�������ݣ�" + str1.isEmpty());
//	3. ת��
//		�ַ�����ת��Ϊ�ַ���
		char[] arr1 = {'a','b','c','d','e','f','g'};
		String str2 = new String(arr1);
		System.out.println(str2);
		
	
	}

}
