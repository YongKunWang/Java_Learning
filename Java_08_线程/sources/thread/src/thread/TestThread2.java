package thread;

/**
 * 1. 创建两个线程，和主线程交替进行
 * 2. 设置和获取线程的名称
 * 3. 设置线程名称有两种方法
 * 		3.1 使用方法来设置
 * 		3.2 继承父类的构造函数来创建
 * 4. 获得当前线程对象：
 * 		通用方法：Thread.currentThread()
 * 		使用this并不通用！！
 * 		验证是否正确：Thread.currentThread() == this
 * @author asdw1
 *
 */

class ThreadDemo extends Thread {
//	直接继承父类的方法就可以了！
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
