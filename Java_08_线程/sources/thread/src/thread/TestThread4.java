package thread;

/**
 * ����������һ�����
 * 	�����������ֱ��300Ԫ��ÿ�δ�100Ԫ
 * 	�滧������
 *  ����.��Ǯ(����)��
 *  ����.��(){Ǯ�Ĳ���ϸ��};
 * 
 * ���Ѱ�ҳ����⣺
 * 	1. ��ȷ��Щ�����Ƕ��߳����д���
 * 		run()��������Ĵ���ȫ�����ǣ���
 * 	2. ��ȷ��������
 * 		�����ȫ�����ǣ���
 *  3. ��ȷ���̴߳����е���Щ��������ǲ����������ݵģ���
 *	
 *	ʹ��ͬ������飡
 *	ʹ��ͬ��������
 */

class Bank {
	private int sum;
//	private Object object = new Object();
	public synchronized void add(int n) {
//		synchronized (object) {
			sum += n;
			try {
				Thread.sleep(10);
				System.out.println("sum : " + sum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
}
class Cus implements Runnable {
	private Bank bank = new Bank();
	public void run() {
		for(int x = 0; x < 3; x ++) {
			bank.add(100);
		}
	}
}

public class TestThread4 {
	public static void main(String[] args) {
		Cus cus = new Cus();
		Thread thread1 = new Thread(cus);
		Thread thread2 = new Thread(cus);
		thread1.start();
		thread2.start();
	}
	
}
