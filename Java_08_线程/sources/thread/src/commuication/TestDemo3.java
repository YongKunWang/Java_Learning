package commuication;

/**
 * 生产者消费者模型
 * 生产者：生产资源
 * 消费者：消费资源
 * 资源：资源生产
 * 		  资源消费
 * 
 * 1. 生产者1个 消费者1个
 * 2. 生产者2个 消费者2个
 * 		出现生产2个，消费一个的情况
 * 3. 情况2与情况1的区别：
 * 		需要每时每刻进行判断标志位
 * 		需要唤醒所有的线程资源
 * 
 * 多线程
 * @author asdw1
 *
 */
class Resources {
	private int count = 0;
	public boolean flag;
	public void in() {
		try {
			Thread.sleep(100);
			System.out.println("The Thread " + Thread.currentThread().getName() + " 生产者..." + " : " + ++ count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void out() {
		try {
			Thread.sleep(100);
			System.out.println("The Thread " + Thread.currentThread().getName() + " 消费者..." + " : " + -- count);
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
		System.out.println("生产者进行生产....");
		while(true) {
			synchronized (resources) {
				//true 生产暂停，消费开始 
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
		System.out.println("消费者进行消费....");
		while(true) {
			synchronized (resources) {
				//false 消费结束，生产开始
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
