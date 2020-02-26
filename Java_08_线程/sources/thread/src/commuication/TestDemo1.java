package commuication;
/**
 * 输入输出模型：
 * 	1. 输入姓名，输出姓名（不间断打印）
 * 		解决的问题：两个线程使用同一个锁
 * 			必须使用同一个锁：person Input.class Output.class
 * 2. 输入姓名，输出姓名，间断打印！！
 * 		wait();
 * 		notify();
 * 		notifyAll();
 * 		这些函数都使用在同步中，因为要对持有监视器（锁）的锁操作
 * 		
 * 		这些函数都定义在了Object类中了：
 * 			因为这些方法在操作线程的时候，都必须进行标记他们所操作的线程只有的锁
 * 			只有同一个被锁上的线程，可以被同一个锁上notify所唤醒
 * 			而锁可以是任意对象，所以被定义在Object类中！！
 * @author asdw1
 *
 */


class Person {
	public String name;
	public String sex;
	boolean flag;
	
}
class Input implements Runnable{
	private Person person;
	private Object object;
	
	Input(Person person){
		this.person = person;
	}
	public void run() {
		int x = 0;
		while(true) {
			synchronized (Input.class) {
				//为true，切换为输出线程
				if(person.flag) {
					try {
						Input.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(x == 0) {
					person.name = "Mark";
					person.sex = "Man";
				}
				else {
					person.name = "丽丽";
					person.sex = "Woman";
				}
				x = (x + 1)% 2;
				
				person.flag = true;
				Input.class.notify();
			}
			
		}
	}
	
}
class Output implements Runnable{
	private Person person;
	Output(Person person){
		this.person = person;
	}
	public void run() {
		while(true) {
			synchronized (Input.class) {
				//false 切换线程
				if(!person.flag) {
					try {
						Input.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(person.name + " : " + person.sex);
				person.flag = false;
				Input.class.notify();
			}
		}
	}
}

public class TestDemo1 {

	public static void main(String[] args) {
		Person person = new Person();
		Thread thread1 = new Thread(new Input(person));
		Thread thread2 = new Thread(new Output(person));
		thread1.start();
		thread2.start();
	}

}
