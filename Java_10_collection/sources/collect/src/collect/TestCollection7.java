package collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet的使用方法
 * 	1. 往TreeSet集合中直接添加一个元素时，不显示错误
 * 	2. 往TreeSet集合中添加多余一个元素时，会显示错误cannot be cast to java.lang.Comparable
 * 		原因：TreeSet为树型结构，Person2类无法进行排序比较
 * 	3. 当强制让人具有比较性之后：
 * 		原顺序输出：返回1
 * 		逆顺序输出：返回-1
 * 4. 方法3，使用的是类对象的内置比较器，如果我们想要按照不同的要求进行排序，则需要修改类本身的内容
 * 		拓展性太差，因此出现了方法5
 * 5. 使用外置类，实现了Comparator接口中的compare方法
 * 		当两种方法同时存在是，优先外置比较方法
 * @author asdw1
 *
 */
class MyCompare implements Comparator {
	public int compare(Object object1,Object object2) {
		if(!(object1 instanceof Person2))
			throw new RuntimeException("非本类对象...");
		if(!(object2 instanceof Person2))
			throw new RuntimeException("非本类对象...");
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
			throw new RuntimeException("不是学生对象");
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
