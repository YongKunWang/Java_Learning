package thread;

/**
 * �򵥵���Ʊ����
 * 1. �ര��ͬʱ��Ʊ��Ʊ���ܹ�100��
 * 		�����ĸ���ͬ�߳�
 * 		�������⣬�̲߳�����Ʊ��,�ĸ�����ͬʱ��100��Ʊ
 * 2. ��ν��������⣿
 * 3. ʹ��һ���߳�ͨ���Ĵ�start�ܷ�������2��
 * 		�������⣺���Ϸ����߳�״̬�쳣
 * 		ԭ�򣺵��̴߳�������̬ʱ��������ͬʱ��������
 * 4. ʹ������ʵ��Runable�ܷ�������2��
 * 		ͨ��ʵ�飬����ʵ�֣���
 * 		����Ϊʲô���д����
 * 5. ���ַ�ʽ������
 * 		���̳�
 * 		��ʵ��
 *		ѧ�����˵�һ�֣��ֿ��Խ��ж��̲߳���
 *
 * 6. ��ǰ��Ʊ���������⣺���������ʱ�����󣬻������������
 * 		���߳�0 �ж��Ժ�����Ȩ�����᣻�߳�2��ʼִ�У�����Ʊ��Ϊ0
 * 		����ȥ���߳�0��ִ��Ʊ��������������Ʊ����Ϊ-1
 * 		Ҳ������˵�İ�ȫ�����⣡��
 * 
 * 7. ��ν������6��ʹ��ͬ������죡��
 * 	Object obj = new Object();
 * synchornized(){
 * 		
 * }
 */
//ʹ�÷���1
class Ticket extends Thread {
	private int ticket = 100;
	public Ticket(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
public void scaleTicket() {
		
		while(true) {
			if(ticket >= 0) {
				try {
					Thread.sleep(10);
					System.out.println("Windows : " + Thread.currentThread().getName() + " ��Ʊ��.....  " + ticket --);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				break;
			}
			
		}
	}
	
	public void run() {
		scaleTicket();
	}
}
//ʹ�÷���2
class TicketR extends Thread {
	
	private int ticket = 100;
	Object obj = new Object();
	public TicketR() {
		// TODO Auto-generated constructor stub
		super();
	}
	public TicketR(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void scaleTicket() {
			while(true) {
				synchronized (obj) {
					if(ticket > 0) {
						try {
							Thread.sleep(10);
							System.out.println("Windows : " + Thread.currentThread().getName() + " ��Ʊ��.....  " + ticket --);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						break;
					}
			}
		}
		
	}
	
	public void run() {
		scaleTicket();
	}
}






public class TestThread3 {
	
	public static void main(String[] args) {
//		Ticket ticket1 = new Ticket("����1");
//		Ticket ticket2 = new Ticket("����2");
//		Ticket ticket3 = new Ticket("����3");
//		Ticket ticket4 = new Ticket("����4");
//		
////		ticket1.start();
////		ticket2.start();
////		ticket3.start();
////		ticket4.start();
//		
//		ticket1.start();
//		ticket1.start();
//		ticket1.start();
//		ticket1.start();
		
		
		TicketR ticketR1 = new TicketR();
		
		Thread thread1 = new Thread(ticketR1);
		Thread thread2 = new Thread(ticketR1);
		Thread thread3 = new Thread(ticketR1);
		Thread thread4 = new Thread(ticketR1);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	
}
