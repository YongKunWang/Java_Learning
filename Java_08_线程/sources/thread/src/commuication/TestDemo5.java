package commuication;
/**
 * 等待线程：
 * 	当A线程执行到了B线程的join方法时，
 *  A就会等待，等B线程结束以后，A才会执行
 * join可以用来临时加入到线程执行
 * @author asdw1
 *
 */

class Demo implements Runnable
{
	public void run()
	{
		for(int x=0; x<70; x++)
		{
			System.out.println(Thread.currentThread().toString()+"....."+x);
			Thread.yield();
		}
	}
}

public class TestDemo5 {

	public static void main(String[] args) throws Exception
	{
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		
		//t1.setPriority(Thread.MAX_PRIORITY);

		t2.start();

		t1.join();

		for(int x=0; x<80; x++)
		{
			System.out.println("main....."+x);
		}
		System.out.println("over");
	}

}
