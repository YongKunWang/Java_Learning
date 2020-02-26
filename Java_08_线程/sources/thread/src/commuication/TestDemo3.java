package commuication;

/**
 * ������������ģ��
 * �����ߣ�������Դ
 * �����ߣ�������Դ
 * ��Դ����Դ����
 * 		  ��Դ����
 * 
 * 1. ������1�� ������1��
 * 2. ������2�� ������2��
 * 		��������2��������һ�������
 * 3. ���2�����1������
 * 		��Ҫÿʱÿ�̽����жϱ�־λ
 * 		��Ҫ�������е��߳���Դ
 * 
 * ���߳�
 * @author asdw1
 *
 */
class Resources {
	private int count = 0;
	public boolean flag;
	public void in() {
		try {
			Thread.sleep(100);
			System.out.println("The Thread " + Thread.currentThread().getName() + " ������..." + " : " + ++ count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void out() {
		try {
			Thread.sleep(100);
			System.out.println("The Thread " + Thread.currentThread().getName() + " ������..." + " : " + -- count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class Product implements Runnable {
	private Resources resources;
	Product(Resources resources){
		this.resources = resources;
	}
	public void run() {
		System.out.println("�����߽�������....");
		while(true) {
			synchronized (resources) {
				//true ������ͣ�����ѿ�ʼ 
//				  if(resources.flag) {
			      while(resources.flag) {
					try {
						resources.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
					resources.in();
					resources.flag = true;
//					resources.notify();
					resources.notifyAll();
			}
		}
	}
}

class Consumer implements Runnable {
	private Resources resources;
	Consumer(Resources resources){
		this.resources = resources;
	}
	public void run() {
		System.out.println("�����߽�������....");
		while(true) {
			synchronized (resources) {
				//false ���ѽ�����������ʼ
//				if (!resources.flag) {
			    while(!resources.flag) {
					try {
						resources.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					resources.out();
					resources.flag = false;
//					resources.notify();
					resources.notifyAll();
			}
		}
	}
}
public class TestDemo3 {

	public static void main(String[] args) {
		Resources resources = new Resources();
		Thread thread1 = new Thread(new Product(resources));
		Thread thread2 = new Thread(new Consumer(resources));
		Thread thread3 = new Thread(new Product(resources));
		Thread thread4 = new Thread(new Consumer(resources));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
