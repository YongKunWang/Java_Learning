package thread;

/**
 * 简单的卖票程序
 * 1. 多窗口同时卖票，票数总共100张
 * 		创建四个相同线程
 * 		出现问题，线程不共享票数,四个窗口同时出100张票
 * 2. 如何解决这个问题？
 * 3. 使用一个线程通过四次start能否解决问题2？
 * 		出现问题：不合法的线程状态异常
 * 		原因：当线程处于运行态时，不能在同时开启！！
 * 4. 使用声明实现Runable能否解决问题2？
 * 		通过实验，可以实现！！
 * 		明白为什么这儿写！！
 * 5. 两种方式的区别：
 * 		单继承
 * 		多实现
 *		学生是人的一种，又可以进行多线程操作
 *
 * 6. 当前售票程序会出问题：当添加了延时操作后，会出现下列现象：
 * 		当线程0 判断以后，运行权被剥夺；线程2开始执行，导致票数为0
 * 		返回去，线程0在执行票数减操作，导致票数变为-1
 * 		也就是所说的安全性问题！！
 * 
 * 7. 如何解决问题6：使用同步代码快！！
 * 	Object obj = new Object();
 * synchornized(){
 * 		
 * }
 */
//使用方法1
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
					System.out.println("Windows : " + Thread.currentThread().getName() + " 卖票中.....  " + ticket --);
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
//使用方法2
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
							System.out.println("Windows : " + Thread.currentThread().getName() + " 卖票中.....  " + ticket --);
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
//		Ticket ticket1 = new Ticket("窗口1");
//		Ticket ticket2 = new Ticket("窗口2");
//		Ticket ticket3 = new Ticket("窗口3");
//		Ticket ticket4 = new Ticket("窗口4");
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
