package collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList ���÷���
 * 	1. �򵥵���ɾ�Ĳ�
 * 
 * @author asdw1
 *
 */

public class TestCollection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method2();
		
	}
	
	public static void method1() {
		ArrayList arr1 = new ArrayList();
		//1.1����
		arr1.add("Java01");
		arr1.add("Java02");
		arr1.add("Java03");
		arr1.add("Java04");
		arr1.add("Java05");
		//1.2���
		arr1.add(1,"Java09");
		
		//1.3ɾ��
		arr1.remove(2);
		//1.4�޸�
		arr1.set(4, "Java05");
		//1.5 ͨ���Ǳ��ȡԪ��
		System.out.println(arr1.get(4));
		
		//1.6 ��ȡ����Ԫ��
		for(int i = 0; i < arr1.size(); i++){
			System.out.println(arr1.get(i));
		}
		//1.7ʹ�õ�������ȡԪ��
		Iterator it = arr1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//1.8 ��ȡ����λ��
		System.out.println("index = " + arr1.indexOf("Java09"));
	}
	
	public static void method2() {
		
		ArrayList arr1 = new ArrayList();
		//1.1����
		arr1.add("Java01");
		arr1.add("Java02");
		arr1.add("Java03");
		arr1.add("Java04");
		arr1.add("Java05");
		
		//2 �������ľ�����
		/**
		 * java.util.ConcurrentModificationException
		 * ���������������޸�ʱ������ͨ����⵽����Ĳ����޸ĵķ������׳����쳣�� 
		 * ���磬һ���߳�ͨ���������޸ļ��ϣ�����һ���߳����ڱ������� 
		 * һ����˵������������£������Ľ����δ����ġ� 
		 * ĳЩ������ʵ�֣�������JRE�ṩ������ͨ�ü���ʵ�ֵ�ʵ�֣�
		 * ���ܻ�ѡ���ڼ�⵽����Ϊʱ�׳����쳣��  
		 */
		Iterator it = arr1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			//error 
			//����˵�����ǵ������ڵ���֮ǰ���Ѿ�ȷ���˼����е�Ԫ����
			//����������Ԫ�أ����ڶ��̲߳���
			//�����ʵ���Ƴ�����������������ͬ�̲߳�������
			//arr1.add(1,"Java06");
			
		}
		//ListԪ�ص����е�����
		//��Ϊ���нǱ꣡��
		ListIterator lit = arr1.listIterator();
		while(lit.hasNext()) {
			
			Object object = lit.next();
			if(object.equals("Java02")) {
				lit.set("Java03");
			}
		}
		
		System.out.println(arr1);
	}

}
