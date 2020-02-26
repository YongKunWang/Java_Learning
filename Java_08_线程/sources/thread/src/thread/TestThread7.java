package thread;

/**
 * �������ģʽ
 * ����ʽ
 * ����ʽ
 * 	���̷߳���ʱ�����ְ�ȫ����
 * 	ʹ��ͬ������� --->�����Ч�����⣬ÿ�ζ����ж�
 * 	ʹ��˫���жϻ���
 * @author asdw1
 *
 */
class Single1 {
	private static Single1 single1 = new Single1();
	private Single1() {}
	public static Single1 getInstance() {
		return single1;
	}
	
}
class Single2 {
	private static Single2 single2 = null;
	private Single2() {}
	public static Single2 getInstance() {
		if(single2 == null){
			synchronized (Single2.class) {
				if(single2 == null)
					single2 = new Single2();
			}
		}
		return single2;
	}
	
}
public class TestThread7 {

}
