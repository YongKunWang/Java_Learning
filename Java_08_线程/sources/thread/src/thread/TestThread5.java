package thread;
/**
 * ��ƱԱ��Ʊ
 * @author asdw1
 * 
 * ͬ������ʹ�õ�����this������
 * ������Ҫ���������ã���ô��������һ��������������������this
 * ����ͬ����ʹ�õ���this
 * 
 * ��Щ����Ϊ��֤���򣡣�
 * 
 * 
 * 
 */


class Ticket2 implements Runnable {
	private int ticket = 100;
	private Object object = new Object();
	public boolean flag = true;
	
	public void scaleTicket() {
		while(true) {
			synchronized (/*object*/this) {
				if(ticket > 0) {
					try {
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName() + " :Scale.... : " + ticket --);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else {
					break;
				}
				
			}
		}
	}
	public synchronized void scaleTicket2() {
			if(ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + " :Scale : " + ticket --);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
	public void run() {
		if(flag) {
			scaleTicket();
		}
		else {
			while(true) {
				scaleTicket2();
			}
				
		}
		
	}
}



public class TestThread5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket2 ticket2 = new Ticket2();
		Thread thread1 = new Thread(ticket2);
		Thread thread2 = new Thread(ticket2);
		thread1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ticket2.flag = false;
		thread2.start();
	}

}
