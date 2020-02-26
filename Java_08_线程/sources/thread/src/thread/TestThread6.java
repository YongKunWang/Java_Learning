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
 * 静态同步函数使用的锁是什么呢？
 * 不是this，在静态中也不能定义this
 * 静态函数进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象
 * 类名.class 该对象类型是Class
 * 非静态方法可以调用静态方法！！
 * 
 * 
 */


class Ticket3 implements Runnable {
	private static int ticket = 100;
	private Object object = new Object();
	public boolean flag = true;
	
	public void scaleTicket() {
		while(true) {
			synchronized (Ticket3.class) {
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
	public static synchronized void scaleTicket2() {
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



public class TestThread6 {

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
