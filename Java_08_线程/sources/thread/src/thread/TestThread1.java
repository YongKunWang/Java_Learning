package thread;

/**
 * 1. ͨ���̳�thread�������߳�
 * 2. ���úͻ�ȡ�̵߳�����
 * 3. Ϊʲô����ʹ��run
 * @author asdw1
 *
 */

class TstThread extends Thread {
	private String name;
	public TstThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("This thread name is " + this.getName() + " my name is : " + this.name);
		}
		
	}
}

public class TestThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TstThread testThread1 = new TstThread("wyk1");
		TstThread testThread2 = new TstThread("wyk2");
		testThread1.setName("T0");
		testThread2.setName("T1");
//		testThread1.start();
//		testThread2.start();
//		ֻ�ǵ��������run��������ʵ��Ϊ���̳߳���
		testThread1.run();
		testThread2.run();
	}

}
