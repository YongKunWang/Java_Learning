package collections;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ���ϱ�Ϊ����
 * 1. ����ΪʲҪ��Ϊ���飿
 * 		Ϊ�˶�����Ԫ�ؽ����޶����޷���������Ԫ�ص���ɾ����
 * 2. ָ�����͵�����ĳ���Ϊ���٣�
 * 		��ָ�����͵�����Ԫ�� < ���ϵ�sizeʱ���÷����ڲ��ᴴ��һ���µ����飬
 * 		����Ϊ���ϵ�size()
 * 		��ָ�����͵�����Ԫ�� > ���ϵ�sizeʱ���Ͳ��ᴴ���µ������ˣ�
 * 		����ʹ�ô��ݽ��������飬������Ķ���Ԫ��Ϊnull
 * 
 * @author asdw1
 *
 */
public class TestDemo3 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Java01");
		arr.add("Java02");
		arr.add("Java03");
		
		
		String[] str = arr.toArray(new String[arr.size()]);
		System.out.println(str);
		for (String string : str) {
			System.out.println(string);
		}
	}

}
