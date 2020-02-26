package thread;

/**
 * 需求：银行有一个金库
 * 	有两个储户分别存300元，每次存100元
 * 	存户存款到银行
 *  储户.存钱(银行)；
 *  银行.存(){钱的操作细节};
 * 
 * 如何寻找出问题：
 * 	1. 明确哪些代码是多线程运行代码
 * 		run()函数里面的代码全部都是！！
 * 	2. 明确共享数据
 * 		类变量全部都是！！
 *  3. 明确多线程代码中的那些多条语句是操作共享数据的！！
 *	
 *	使用同步代码块！
 *	使用同步函数！
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
