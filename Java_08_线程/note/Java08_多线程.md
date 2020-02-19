# 多线程技术

## 进程和线程简介

```java
/*
进程：是一个正在执行中的程序。

	每一个进程执行都有一个执行顺序。该顺序是一个执行路径，或者叫一个控制单元。

线程：就是进程中的一个独立的控制单元。

		线程在控制着进程的执行。

一个进程中至少有一个线程。

Java VM  启动的时候会有一个进程java.exe.

该进程中至少一个线程负责java程序的执行。

而且这个线程运行的代码存在于main方法中。

该线程称之为主线程。

扩展：其实更细节说明jvm，jvm启动不止一个线程，还有负责垃圾回收机制的线程。



1,如何在自定义的代码中，自定义一个线程呢？

通过对api的查找，java已经提供了对线程这类事物的描述。就Thread类。

创建线程的第一种方式：继承Thread类。

步骤：

1，定义类继承Thread。

2，复写Thread类中的run方法。

	目的：将自定义代码存储在run方法。让线程运行。

3，调用线程的start方法，

	该方法两个作用：启动线程，调用run方法。



发现运行结果每一次都不同。

因为多个线程都获取cpu的执行权。cpu执行到谁，谁就运行。

明确一点，在某一个时刻，只能有一个程序在运行。(多核除外)

cpu在做着快速的切换，以达到看上去是同时运行的效果。

我们可以形象把多线程的运行行为在互相抢夺cpu的执行权。

这就是多线程的一个特性：随机性。谁抢到谁执行，至于执行多长，cpu说的算。



为什么要覆盖run方法呢？

Thread类用于描述线程。

该类就定义了一个功能，用于存储线程要运行的代码。该存储功能就是run方法。

也就是说Thread类中的run方法，用于存储线程要运行的代码。


*/
```

代码示例：

```java
package thread;

/**
 * 1. 通过继承thread来运行线程
 * 2. 设置和获取线程的名称
 * 3. 为什么不能使用run
 * @author asdw1
 *
 */

class TestThread extends Thread {
	private String name;
	public TestThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("This thread name is " + this.getName() + " my name is : " + this.name);
		}
		
	}
}

public class ThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread testThread1 = new TestThread("wyk1");
		TestThread testThread2 = new TestThread("wyk2");
		testThread1.setName("T0");
		testThread2.setName("T1");
//		testThread1.start();
//		testThread2.start();
//		只是调用了类的run方法，其实质为单线程程序
		testThread1.run();
		testThread2.run();
	}

}

```

## 获得线程的对象和名称

```java
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
		// TODO Auto-generated constructor stub
//		this.name = name;
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("This thread name is " +( Thread.currentThread()== this) +" : "+Thread.currentThread().getName() + " This is Thread...");
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}


public class TestThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
```

## 例子：售票员

```java

/*
需求：简单的卖票程序。
多个窗口同时买票。


创建线程的第二种方式：实现Runable接口

步骤：
1，定义类实现Runnable接口
2，覆盖Runnable接口中的run方法。
	将线程要运行的代码存放在该run方法中。

3，通过Thread类建立线程对象。
4，将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数。
	为什么要将Runnable接口的子类对象传递给Thread的构造函数。
	因为，自定义的run方法所属的对象是Runnable接口的子类对象。
	所以要让线程去指定指定对象的run方法。就必须明确该run方法所属对象。


5，调用Thread类的start方法开启线程并调用Runnable接口子类的run方法。



实现方式和继承方式有什么区别呢？

实现方式好处：避免了单继承的局限性。
在定义线程时，建立使用实现方式。

两种方式区别：
继承Thread:线程代码存放Thread子类run方法中。
实现Runnable，线程代码存在接口的子类的run方法。
------------------------------------------------------------------
通过分析，发现，打印出0，-1，-2等错票。

多线程的运行出现了安全问题。

问题的原因：
	当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完，
	另一个线程参与进来执行。导致共享数据的错误。

解决办法：
	对多条操作共享数据的语句，只能让一个线程都执行完。在执行过程中，其他线程不可以参与执行。

-----------------------------------------------------------------
Java对于多线程的安全问题提供了专业的解决方式。

就是同步代码块。

synchronized(对象)
{
	需要被同步的代码

}
对象如同锁。持有锁的线程可以在同步中执行。
没有持有锁的线程即使获取cpu的执行权，也进不去，因为没有获取锁。

火车上的卫生间---经典。

同步的前提：
1，必须要有两个或者两个以上的线程。
2，必须是多个线程使用同一个锁。

必须保证同步中只能有一个线程在运行。


好处：解决了多线程的安全问题。

弊端：多个线程需要判断锁，较为消耗资源，

```

```java
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
		synchronized (obj) {
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
```



