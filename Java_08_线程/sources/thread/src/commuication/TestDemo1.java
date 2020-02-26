package commuication;
/**
 * �������ģ�ͣ�
 * 	1. �����������������������ϴ�ӡ��
 * 		��������⣺�����߳�ʹ��ͬһ����
 * 			����ʹ��ͬһ������person Input.class Output.class
 * 2. ���������������������ϴ�ӡ����
 * 		wait();
 * 		notify();
 * 		notifyAll();
 * 		��Щ������ʹ����ͬ���У���ΪҪ�Գ��м�������������������
 * 		
 * 		��Щ��������������Object�����ˣ�
 * 			��Ϊ��Щ�����ڲ����̵߳�ʱ�򣬶�������б���������������߳�ֻ�е���
 * 			ֻ��ͬһ�������ϵ��̣߳����Ա�ͬһ������notify������
 * 			��������������������Ա�������Object���У���
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
				//Ϊtrue���л�Ϊ����߳�
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
					person.name = "����";
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
				//false �л��߳�
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
