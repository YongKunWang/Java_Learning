package collect;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet存储自定义对象
 * @author asdw1
 *
 */
class Person1 {
	private String name;
	private int age;
	public Person1(String name, int age) {
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
	public int hashCode() {
		System.out.println("HashCode...");
		return this.name.hashCode() + age*37;
	}
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + "]";
	}
	
	@Override 
	public boolean equals(Object object) {
		if(!(object instanceof Person1)) {
			return false;
		}
		Person1 person1 = (Person1)object;
		return this.name.equals(person1.name) && this.age == person1.age;
	}
	
	
}

public class TestCollection6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet ha = new HashSet();
		ha.add(new Person1("a1", 21));
		ha.add(new Person1("a2", 22));
		ha.add(new Person1("a3", 23));
		ha.add(new Person1("a1", 21));
		
		for(Iterator it = ha.iterator(); it.hasNext();) {
			System.out.println(it.next().toString());
		}
	}

}
