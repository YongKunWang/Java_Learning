package fanxing1;

/**
 * 1. ���ַ���ǰ�ͳ��ַ��ͺ������
 * 		���幤����Tool
 * 		��������չ��˺�ѧ��
 * 		ֻ���˹��ж�����������ת�͵���ȷ�ԣ�����ʱ�޷�ȷ��
 * 2. ���͵�����
 * 
 * @author asdw1
 *
 */

class Tool {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}

class Student {
	
}
class Worker{
	
}


class Utilss<T>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}


public class TestDemo3 {

	public static void main(String[] args) {
		Tool tool = new Tool();
		tool.setObject(new Student());
		Worker worker = (Worker)tool.getObject();
		
		Utilss<Worker> utilss = new Utilss<Worker>();
		utilss.setObj(new Worker());
		Worker worker2 = (Worker)utilss.getObj();

	}

}
