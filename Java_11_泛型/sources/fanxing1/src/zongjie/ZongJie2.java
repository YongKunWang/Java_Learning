package zongjie;
/**
 * 1.һ���ڱ���׶μ�ⲻ���������н׶ε�����ת���쳣
 * 2. �������Ĵ��������������1
 * 		�ô���
 * 			������ʱ����ת�Ƶ��˱���ʱ��
 * 			����������ǿ��ת�����鷳
 * 			�������Ա������⣬������ʱ�������
 * 3. ���͵ĸ�ʽ��
 * 		������ ������ С���Ŷ������ˣ�ֻ��ʹ�ü������ˣ�	
 * 4. ����ӷ����Ժ�IDE�����£������ڱ�дʱ�ھͻ��Զ��ı�����
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ZongJie2 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Java01");
//		arr.add(4);
//		arr.add(new Integer(5));
		
		for(Iterator<String> it = arr.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
