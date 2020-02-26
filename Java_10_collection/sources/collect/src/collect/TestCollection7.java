package collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet��ʹ�÷���
 * 	1. ��TreeSet������ֱ�����һ��Ԫ��ʱ������ʾ����
 * 	2. ��TreeSet��������Ӷ���һ��Ԫ��ʱ������ʾ����cannot be cast to java.lang.Comparable
 * 		ԭ��TreeSetΪ���ͽṹ��Person2���޷���������Ƚ�
 * 	3. ��ǿ�����˾��бȽ���֮��
 * 		ԭ˳�����������1
 * 		��˳�����������-1
 * 4. ����3��ʹ�õ������������ñȽ��������������Ҫ���ղ�ͬ��Ҫ�������������Ҫ�޸��౾�������
 * 		��չ��̫���˳����˷���5
 * 5. ʹ�������࣬ʵ����Comparator�ӿ��е�compare����
 * 		�����ַ���ͬʱ�����ǣ��������ñȽϷ���
 * @author asdw1
 *
 */
class MyCompare implements Comparator {
	public int compare(Object object1,Object object2) {
		if(!(object1 instanceof Person2))
			throw new RuntimeException("�Ǳ������...");
		if(!(object2 instanceof Person2))
			throw new RuntimeException("�Ǳ������...");
		Person2 person21 = (Person2)object1;
		Person2 person22 = (Person2)object2;
		int num = person21.getName().compareTo(person22.getName());
		if(num == 0){
			return new Integer(person21.getAge()).compareTo(new Integer(person22.getAge()));
		}
		return num;
	}
}
class Person2 implements Comparable {
	private String name;
	private int age;
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + "]";
	}
	
	public int compareTo(Object object) {
		if(!(object instanceof Person2))
			throw new RuntimeException("����ѧ������");
		Person2 person2 = (Person2)object;
		
		if(this.age > person2.age)
			return 1;
		if(this.age == person2.age) {
			return this.name.compareTo(person2.name);
		}
		return -1;
	}
	
}


public class TestCollection7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet tr = new TreeSet(new MyCompare());
		tr.add(new Person2("Lisi01", 21));
		tr.add(new Person2("Lisi02", 21));
		tr.add(new Person2("Lisi01", 27));
		tr.add(new Person2("Lisi02", 23));
		tr.add(new Person2("Lisi01", 24));
		tr.add(new Person2("Lisi02", 25));
		
		for(Iterator it = tr.iterator(); it.hasNext();) {
			System.out.println(it.next().toString());
		}

		
	}

}
