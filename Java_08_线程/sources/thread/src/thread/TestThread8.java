package thread;

/**
 * 死锁的产生：
 * 	多个同步锁的嵌套
 * @author asdw1
 *
 */
class DeadLockTest implements Runnable {
	private boolean flag;
	DeadLockTest(){
		
	}
	DeadLockTest(boolean flag){
		this.flag = flag;
	}
	
	public void run() {
		
		if(flag) {
			while(true) {
				synchronized (Lock.aLock) {
					System.out.println("if aLck...");
					synchronized (Lock.bLock) {
						System.out.println("if bLck...");
					}
				}
			}
		}
		else {
			while(true) {
				synchronized (Lock.bLock) {
					System.out.println("else bLck...");
					synchronized (Lock.aLock) {
						System.out.println("else aLck...");
					}
				}
			}
			
		}
	}
}

class Lock {
	public static Object aLock = new Object();
	public static Object bLock = new Object();
}

public class TestThread8 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new DeadLockTest(true));
		Thread thread2 = new Thread(new DeadLockTest(false));
		thread1.start();
		thread2.start();
	}
}
