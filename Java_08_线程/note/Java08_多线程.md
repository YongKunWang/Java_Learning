# 多线程技术

[TOC]

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
```

## 同步代码块和同步函数

```java
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

```

```java
package thread;
/**
 * 售票员售票
 * @author asdw1
 * 
 * 同步函数使用的锁是this锁！！
 * 函数需要被对象引用，那么哈数都有一个所属对象，这个对象就是this
 * 所以同步锁使用的是this
 * 
 * 这些代码为验证程序！！
 * 
 * 
 * 
 */
class Ticket2 implements Runnable {
	private int ticket = 100;
	private Object object = new Object();
	public boolean flag = true;
	
	public void scaleTicket() {
		while(true) {
			synchronized (/*object*/this) {
				if(ticket > 0) {
					try {
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName() + " :Scale.... : " + ticket --);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else {
					break;
				}
				
			}
		}
	}
	public synchronized void scaleTicket2() {
			if(ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + " :Scale : " + ticket --);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
	public void run() {
		if(flag) {
			scaleTicket();
		}
		else {
			while(true) {
				scaleTicket2();
			}
				
		}
		
	}
}

public class TestThread5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket2 ticket2 = new Ticket2();
		Thread thread1 = new Thread(ticket2);
		Thread thread2 = new Thread(ticket2);
		thread1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ticket2.flag = false;
		thread2.start();
	}

}

```

## 同步静态代码块

```java
package thread;
/**
 * 售票员售票
 * @author asdw1
 * 
 * 同步函数使用的锁是this锁！！
 * 函数需要被对象引用，那么哈数都有一个所属对象，这个对象就是this
 * 所以同步锁使用的是this
 * 
 * 这些代码为验证程序！！
 * 
 * 静态同步函数使用的锁是什么呢？
 * 不是this，在静态中也不能定义this
 * 静态函数进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象
 * 类名.class 该对象类型是Class
 * 非静态方法可以调用静态方法！！
 * 
 * 
 */


class Ticket3 implements Runnable {
	private static int ticket = 100;
	private Object object = new Object();
	public boolean flag = true;
	
	public void scaleTicket() {
		while(true) {
			synchronized (Ticket3.class) {
				if(ticket > 0) {
					try {
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName() + " :Scale.... : " + ticket --);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else {
					break;
				}
				
			}
		}
	}
	public static synchronized void scaleTicket2() {
			if(ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + " :Scale : " + ticket --);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
	public void run() {
		if(flag) {
			scaleTicket();
		}
		else {
			while(true) {
				scaleTicket2();
			}
				
		}
		
	}
}



public class TestThread6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket2 ticket2 = new Ticket2();
		Thread thread1 = new Thread(ticket2);
		Thread thread2 = new Thread(ticket2);
		thread1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ticket2.flag = false;
		thread2.start();
	}

}

```

## 单例设计模式

```java
package thread;

/**
 * 单例设计模式
 * 饿汉式
 * 懒汉式
 * 	多线程访问时，出现安全问题
 * 	使用同步代码块 --->会产生效率问题，每次都得判断
 * 	使用双重判断机制
 * @author asdw1
 *
 */
class Single1 {
	private static Single1 single1 = new Single1();
	private Single1() {}
	public static Single1 getInstance() {
		return single1;
	}
	
}
class Single2 {
	private static Single2 single2 = null;
	private Single2() {}
	public static Single2 getInstance() {
		if(single2 == null){
			synchronized (Single2.class) {
				if(single2 == null)
					single2 = new Single2();
			}
		}
		return single2;
	}
	
}
public class TestThread7 {

}

```

## 死锁

```java
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

```

# 多线程通信

## 顺序操作

```java
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

```

改进版本：

```java
package commuication;
/**
 * 上一个版本的修改版本
 * 无法直接访问类变量，使用同步函数进行访问！！
 * @author asdw1
 *
 */

class Person1{
	private String name;
	private String sex;
	boolean flag;
	
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized String getSex() {
		return sex;
	}
	public synchronized void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", sex=" + sex + "]";
	}
	
}

class Input1 implements Runnable{
	private Person1 person1;
	Input1(Person1 person1){
		this.person1 = person1;
	}
	public void run() {
		int x = 0;
		while(true) {
			synchronized (person1) {
				if (person1.flag) {
					try {
						person1.wait();
					} catch (Exception e) {
						e.printStackTrace();					}
				}
				if(x == 0) {
					person1.setName("Mark");
					person1.setSex("Man");
				}
				else {
					person1.setName("丽丽");
					person1.setSex("Woman");
				}
				x = (x + 1)% 2;
				person1.flag = true;
				person1.notify();
			}
		}
	}
}
class Output1 implements Runnable{
	private Person1 person1;
	Output1(Person1 person1){
		this.person1 = person1;
	}
	public void run() {
		while(true) {
			synchronized (person1) {
				//false 切换线程
				if(!person1.flag) {
					try {
						person1.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(person1.toString());
				person1.flag = false;
				person1.notify();
			}
		}
	}
}

public class TestDemo2 {

	public static void main(String[] args) {
		Person1 person1 = new Person1();
		new Thread(new Input1(person1)).start();
		new Thread(new Output1(person1)).start();
	}

}

```

## 生产者消费者模型

```java
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
```

## 停止线程

```java
/*
stop方法已经过时。

如何停止线程？
只有一种，run方法结束。
开启多线程运行，运行代码通常是循环结构。

只要控制住循环，就可以让run方法结束，也就是线程结束。


特殊情况：
当线程处于了冻结状态。
就不会读取到标记。那么线程就不会结束。

当没有指定的方式让冻结的线程恢复到运行状态是，这时需要对冻结进行清除。
强制让线程恢复到运行状态中来。这样就可以操作标记让线程结束。

Thread类提供该方法 interrupt();



*/
```

```java
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

```

## 守护线程

```java
将此线程标记为daemon线程或用户线程。 当运行的唯一线程都是守护进程线程时，Java虚拟机将退出。 
线程启动前必须调用此方法。
setDaemon(true);
守护进程相当于后台线程
当前台线程结束后，后台线程也自动结束！
```

## 等待进程

```java
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

```

## 测试过程

```java
class MyThread extends Thread{
	public void run(){
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("MyThread running");
	}
}



public class ThreadTest{
	public static void main(String argv[]) {
		MyThread t = new MyThread();
		t.run();
		t.start();
		System.out.println("Thread Test");
	  }
}

/*
代码分析过程：

MyThread t = new MyThread();
创建了一个线程。

t.run();
调用MyThread对象的run方法。
这是只有一个线程在运行就是主线程。
当主线程执行到了run方法中的sleep(3000);时。
这是主线程处于冻结状态。程序并没有任何执行。
当3秒过后，主线程打印了  MyThread running。 run方法执行结束。

t.start();
开启了t线程。
有两种可能情况。
第一种，主线程在只执行了t.start()后，还具有执行权，继续往下执行，
打印了Thread Test。主线程结束。
t线程获取执行权，调用自己的run方法。然后执行的sleep(3000);冻结3秒。
3秒后，打印MyThread running t线程结束，整个程序结束。

第二种情况：
主线程执行到t.start();开启了t线程，t线程就直接获取到了执行权。
就调用自己的run方法。
指定到sleep(3000).t线程冻结3秒，这是t线程就是释放了执行权。
那么主线程开始执行打印了Thread Test，主线程结束。
等到3秒后，t线程打印MyThread running ，然后t线程结束。
程序结束。
*/


```



