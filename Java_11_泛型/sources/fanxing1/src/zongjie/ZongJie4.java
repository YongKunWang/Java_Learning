package zongjie;
/**
 * ���ͳ���ǰ�ͷ��ͳ��ֺ������
 * ������ļ�ʹ��
 * @author asdw1
 */

class Tool {
	private Object obj;
	Tool(Object obj){
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
}
class Worker {
	public void  show() {
		System.out.println("���ڹ�����...");
	}
}
class Student {
	public void  show() {
		System.out.println("����ѧϰ��...");
	}
}

class Utils <T> {
	private T obj;
	Utils(T obj){
		this.obj = obj;
	}
	public T getObj() {
		return obj;
	}
}

public class ZongJie4 {

	public static void main(String[] args) {
		Tool t = new Tool(new Worker());
		Worker w1 = (Worker)t.getObj();
		w1.show();
		//����ת���쳣
//		Student s1 = (Student)t.getObj();
//		s1.show();
		
		
		/* 1. ������ʱ�ڴ���ת�Ƶ�����ʱ��
		 * 2. ����������ʱ�ڵĳ�����󣬰�ȫ
		 * 3. ������ǿ��ת��
		 */
		Utils<Worker> u1 = new Utils(new Worker());
		u1.getObj().show();
	}

}
