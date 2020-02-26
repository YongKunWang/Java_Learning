package commuication;
/**
 * 1. 停止普通线程
 * 		控制线程部分，只要控制线程的循环部分就可以实现了
 * 2. 停止含有其他状态的线程,注意加上同步代码块
 * 		当线程处于冻结状态时，使用方法1时，线程不会结束
 *      当没有指定的方法让冻结的线程恢复到运行状态时，这是需要对冻结进行清除
 *      强制让线程恢复到运行状态中来，这样就可以通过标记来让线程结束
 *      
 * @author asdw1
 *
 */


class StopThread implements Runnable {
	private boolean flag = true;
	public synchronized  void run() {
		
		while(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+"....Exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+"....run");
		}
	}
	public void changeFlag() {
		flag = false;
	}
}


public class TestDemo4 {

	public static void main(String[] args) {
		
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.start();
		
		t2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int num = 0;

		while(true)
		{
			if(num++ == 60)
			{
				st.changeFlag();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......."+num);
		}
		System.out.println("over");
	}

}
