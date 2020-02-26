package test;

/*
1��ģ��һ��trim������ȥ���ַ������˵Ŀո�
	˼·��
	1���ж��ַ�����һ��λ���Ƿ��ǿո�����Ǽ��������жϣ�ֱ�����ǿո�Ϊֹ��
		��β���жϿո�Ҳ����ˡ�
	2������ʼ�ͽ�β���жϵ����ǿո�ʱ������Ҫ��ȡ���ַ�����

2����һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת��"abcdefg";abfedcg
	˼·��
	1������ѧϰ���������Ԫ�ؽ��з�ת��
	2�����ַ���������飬�����鷴ת��
	3������ת����������ַ�����
	4��ֻҪ����ת�Ĳ��ֵĿ�ʼ�ͽ���λ����Ϊ�������ݼ��ɡ�


*/

public class TestString3 {

	public static void sop (String str) {
		System.out.println(str);
	}
//����1. ɾ���ַ���ǰ��Ŀո�
	public static String myTrim(String str) {
		//ǰ������ֵ
		int start = 0; 
		int end = str.length() -1;
		while(start < end && str.charAt(start)== ' ')
			start ++;
		while (start <end && str.charAt(end) == ' ') 
			end --;
//		substring(start,end)
//		start:��ʼ
//		end  :����(������)
		return str.substring(start, end+1);
		//smiles 1,5 mile
		
	}
//	����2. �ַ�����ת
//	Hello-World!!  0 4 --> Hello  olleH
	public static String reverseString(String str,int start,int end) {
		//1. �ַ���ת��Ϊ�ַ�������
		char[] chs = str.toCharArray();
		//2.����ָ��λ�õ��ַ������鷴ת
		reverse(chs, start, end);
		return new String(chs);
	}
	private static void reverse(char[] chs, int x, int y) {
		for(int start = x, end = y;start <= end;start ++,end --) {
			swap(chs,start,end);
		}
	}
	private static void swap(char[] chs, int x, int y) {
		char temp = chs[x];
		chs[x] = chs[y];
		chs[y] = temp;
	}
	public static void main(String[] args) {
		String str1 = "   Hello World!!   ";
		String str2 = "Hello-World!!";
		sop(myTrim(str1));
		sop(reverseString(str2,0,1));
	}
}
