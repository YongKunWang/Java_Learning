package collect;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;

public class TestCollection1 {

	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.add("Java01");
		arrayList.add("Java02");
		arrayList.add("Java03");
		arrayList.add("Java04");
		arrayList.add("Java05");
		arrayList.add("Java06");
		
		//1. ȡ��Ԫ��
		Iterator iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			sop(iterator.next());
		}
		
		//2. ȡ����
		ArrayList arrayList1 = new ArrayList();
		arrayList1.add("Java01");
		arrayList1.add("Java02");
		ArrayList arrayList2 = new ArrayList();
		arrayList2.add("Java01");
		arrayList2.add("Java02");
		arrayList2.add("Java03");
		arrayList2.add("Java04");
		arrayList2.retainAll(arrayList1);
		sop(arrayList2);
		// 3. ��ȡ���ϳ���
		sop(arrayList.size());
		//4.��ѯ����
		sop(arrayList.contains("Java01"));
		
		
		
	}
	public static void sop(Object object) {
		System.out.println(object);
	}

}
