package thread;

/**
 * 1. 通过继承thread来运行线程
 * 2. 设置和获取线程的名称
 * 3. 为什么不能使用run
 * @author asdw1
 *
 */

class TstThread extends Thread {
	private String name;
	public TstThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("This thread name is " + this.getName() + " my name is : " + this.name);
		}
		
	}
}

public class TestThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TstThread testThread1 = new TstThread("wyk1");
		TstThread testThread2 = new TstThread("wyk2");
		testThread1.setName("T0");
		testThread2.setName("T1");
//		testThread1.start();
//		testThread2.start();
//		只是调用了类的run方法，其实质为单线程程序
		testThread1.run();
		testThread2.run();
	}

}
