package fanxing1;

/**
 * 1. ���Ͷ����ڽӿ���
 * 		�ӿ���ȷ����������
 * 2. �ӿ���δ��ȷ�ӿ�����
 * @author asdw1
 *
 */

interface Inter <T>{
	void show(T t);
}
/*ʵ������ȷ����������*/
class InterImpl implements Inter<String>{
	public void show(String string) {
		System.out.println(string);
	}
}

/*�ӿ���δ��ȷ�ӿ�����*/
class InterImpll<T> implements Inter<T>{
	public void show(T t) {
		System.out.println(t);
	}
}

public class TestDemo5 {

	public static void main(String[] args) {
		InterImpl interImpl = new InterImpl();
		interImpl.show("dsds");
		InterImpll<Integer> interImpll = new InterImpll<Integer>();
		interImpll.show(123);
		
	}

}
