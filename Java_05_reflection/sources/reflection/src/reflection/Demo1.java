package reflection;

import reflection.Work;
import reflection.Student;

import java.lang.reflect.Field;

/**
 * ��ȡClass����ķ�����
 * 	1. �ֽ��룺
 * 		Class.forName("ȫ����(���ʹ�ø��Ƶķ���)");
 * 			�˷������ֽ����ļ����ؽ����ڴ棬����Class����
 * 	2. �ֽ�����ؽ����ڴ�
 * 		Class.class
 * 			ͨ������������class��ȡ
 * 	3. ������ʵ������
 * 		Instance.getClass()
 * 			getClass()������Object���ж�����
 *
 */


public class Demo1 {

	public static void main(String[] args) throws Exception {
		System.out.println("--------ʹ�����ַ���ʵ�ֶ���Ļ�ȡ----------");
		Class cls1 = Class.forName("reflection.Work");
		System.out.println(cls1);
		
		Class cls2 = Work.class;
		System.out.println(cls2);
		
		Work work = new Work("wyk1",19,"��","1001");
		Class cls3 = work.getClass();
		System.out.println(cls3);
		System.out.println("==========================");
//		��ȡ���б�public�����ε������
		Field[] fields = cls1.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println("--------------------");
		Field name = cls3.getField("name");
		System.out.println(name);
		Work work2 = new Work("wyk1",19,"��","1001");
		Object value = name.get(work2);
		System.out.println(value);
		name.set(work2, "Wyk3");
		work2.show();
	}

}
