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
