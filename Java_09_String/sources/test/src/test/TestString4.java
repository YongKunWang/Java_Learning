package test;

 /*
 3����ȡһ���ַ�������һ���ַ����г��ֵĴ�����
 	"abkkcdkkefkkskk"


 	˼·��
 	1���������������
 	2����ȡkk��һ�γ��ֵ�λ�á�
 	3���ӵ�һ�γ���λ�ú�ʣ����ַ����м�����ȡkk���ֵ�λ�á�
 		ÿ��ȡһ�ξͼ���һ�Ρ�
 	4������ȡ����ʱ��������ɡ�
 */
 
public class TestString4 {
	public static void sop(String str){
		System.out.println(str);
	}
	public static int  getSubCount(String str,String key) {
		int count = 0;
		int index = 0;
		//��һ�γ���key�ַ�������ֵ
		while((index=str.indexOf(key))!= -1) {
			str = str.substring(index+key.length());
//			sop(str);
			count ++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String string = "abkkcdkkefkkskk";
		int count = getSubCount(string,"k");
		System.out.println(count);
	}

}
