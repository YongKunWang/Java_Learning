package collect;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet���÷�
 * 	1. Ϊʲô.add�������ص�ֵ��boolean�ͣ�
 * 		��Ϊ���ж��Ƿ�����˼�����
 * 	2. HashSet����ж��ظ�Ԫ�أ�
 * 		2.1 ͨ���жϹ�ϣֵ�����ж��Ƿ����ظ�ֵ
 * 			Ԫ�صĴ洢�����ǰ��չ�ϣֵ�Ĵ�С���ϵ��½��������
 * 			��������뼯�ϵ�˳��һ��
 * 		2.2 ����ϣֵһ���ǣ�ͨ���ж϶����Ƿ�һ�����ж�ʯ����ͬһ������equals��
 * 		2.3 ����ϣֵһ��ʱ���Ҷ���һ���ǣ����ں������˳��
 * 
 * @author asdw1
 *
 */

public class TestCollection5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet ha = new HashSet();
		System.out.println(ha.add("Java01"));
		System.out.println(ha.add("Java01"));
		ha.add("Java02");
		ha.add("Java03");
		ha.add("Java04");
		ha.add("Java04");
		
		Iterator it = ha.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
