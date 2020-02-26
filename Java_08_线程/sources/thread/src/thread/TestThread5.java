package thread;
/**
 * 售票员售票
 * @author asdw1
 * 
 * 同步函数使用的锁是this锁！！
 * 函数需要被对象引用，那么哈数都有一个所属对象，这个对象就是this
 * 所以同步锁使用的是this
 * 
 * 这些代码为验证程序！！
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
