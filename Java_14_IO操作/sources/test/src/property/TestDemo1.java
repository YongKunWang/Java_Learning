package property;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
Properties��hashtable�����ࡣ
Ҳ����˵���߱�map���ϵ��ص㡣����������洢�ļ�ֵ�Զ����ַ�����

�Ǽ����к�IO�������ϵļ���������

�ö�����ص㣺�������ڼ�ֵ����ʽ�������ļ���

��ô�ڼ�������ʱ����Ҫ�����й̶���ʽ����=ֵ��
 */

public class TestDemo1 {
	public static void main(String[] args) throws IOException{
//		setAndGet();
//		method1();
		method2();
	} 
	//ʹ��properties�ķ�����ȡ�ͱ��������ļ�
	public static void method2() throws IOException{
		Properties pr = new Properties();
		FileInputStream fr = new FileInputStream("info.txt");

		pr.load(fr);
		System.out.println(pr);
		pr.setProperty("aaa", "70");
		//���λ���н����ģ���������������������
		FileOutputStream fw = new FileOutputStream("info.txt");
		pr.store(fw,"haha");
		pr.list(System.out);
		fw.close();
		fr.close();
	}
	//���ļ���ȡ�����ļ�
	public static void method1() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		
		String line = null;
		Properties pr = new Properties();
		while((line = br.readLine()) != null) {
			String[] arr = line.split("=");
			pr.setProperty(arr[0], arr[1]);
		}
		System.out.println(pr);
		br.close();
	
	}
	
	//��ʼ�����ұ���
	public static void setAndGet() {
		Properties pr = new Properties();
		pr.setProperty("zhangsan", "30");
		pr.setProperty("lisi", "40");
		
		System.out.println(pr);
		
		System.out.println(pr.getProperty("lisi"));
		
		//����
		Set<String> names = pr.stringPropertyNames();
		for(String s : names)
			System.out.println(s +" : "+ pr.getProperty(s));

	}
}
