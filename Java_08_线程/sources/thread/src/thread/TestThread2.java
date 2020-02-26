package thread;

/**
 * 1. ���������̣߳������߳̽������
 * 2. ���úͻ�ȡ�̵߳�����
 * 3. �����߳����������ַ���
 * 		3.1 ʹ�÷���������
 * 		3.2 �̳и���Ĺ��캯��������
 * 4. ��õ�ǰ�̶߳���
 * 		ͨ�÷�����Thread.currentThread()
 * 		ʹ��this����ͨ�ã���
 * 		��֤�Ƿ���ȷ��Thread.currentThread() == this
 * @author asdw1
 *
 */

class ThreadDemo extends Thread {
//	ֱ�Ӽ̳и���ķ����Ϳ����ˣ�
//	private String name;
	public ThreadDemo(String name) {
//		this.name = name;
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("This thread name is " +( Thread.currentThread()== this) +" : "+Thread.currentThread().getName() + " This is Thread...");
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
}


public class TestThread2 {

	public static void main(String[] args) {
		ThreadDemo threadDemo1 = new ThreadDemo("wyk1");
		ThreadDemo threadDemo2 = new ThreadDemo("wyk2");
//		threadDemo1.setName("T0");
//		threadDemo2.setName("T1");
		threadDemo1.start();
		threadDemo2.start();
		
		for (int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(300);
				System.out.println("This thread is Main..." );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
