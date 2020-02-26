package collect;

import java.util.ArrayList;
import java.util.Iterator;

class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person person = (Person)obj;
		return this.age == person.age;
	}
	
}


public class TestCollection4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList arrayList = new ArrayList();
		arrayList.add(new Person("aa",31));
		arrayList.add(new Person("bb",32));
		arrayList.add(new Person("cc",33));
		arrayList.add(new Person("aa",31));
		arrayList.add(new Person("bb",32));
		arrayList.add(new Person("cc",33));
		System.out.println("Ç°£º");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).toString());
		}
		System.out.println("ºó£º");
		arrayList = singleElement(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).toString());
		}
		
		
	}
	public static ArrayList singleElement(ArrayList arr) {
		ArrayList newarr = new ArrayList();
		Iterator it = arr.iterator();
		while(it.hasNext()) {
			Object object = it.next();
			if(!newarr.contains(object)) {
				newarr.add(object);
			}
		}
		return newarr;
	}
}
