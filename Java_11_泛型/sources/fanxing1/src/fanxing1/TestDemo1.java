package fanxing1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1. �����ڼ䲻�������⣬�����ڼ����������ת���쳣
 * 2. Ϊ�˽������1���������Ĵ�����(JDK1.5)
 * 3. �ô���
 * 		������ʱ�ڳ�������ClassCastException��ת�Ƶ��˱���ʱ��
 * 		�����ڳ���Ա������⡣������ʱ������٣���ȫ��
 * 		������ǿ��ת���鷳
 * 4. ���͵ĸ�ʽ��
 * 		ʹ��<>������Ҫ������������������
 * 5. ʲôʱ��д�����أ�
 * 		ͨ���ڼ��Ͽ���кܳ���
 * 		ֻҪ����<>��Ҫ���巺��
 * @author asdw1
 *
 */

public class TestDemo1 {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Java01");
		arrayList.add("Java01");
		//arrayList.add(4);
		
		for(Iterator<String> it = arrayList.iterator();it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
