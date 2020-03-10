package learning;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 1. 例子：人
 * 		每一个学生都对应的归属地
 * 		年龄和姓名相同被视为同一个学生
 * 		保证学生的唯一性
 * @author asdw1
 *
 */

class MyCmp implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return -1;
	}
}

class Student implements Comparable<Student>{
	private String name;
	private int age;
	public Student(String name, int age) {
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
	
	public int hashCode() {
		return this.name.hashCode() + age * 11;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Student))
			throw new RuntimeException("类型不匹配...");
		Student s = (Student)obj;
		
		return this.name.equals(s.name) && this.age == s.age;
	}
	
	public int compareTo(Student s1) {
		System.out.println("...");
		int num = new Integer(this.age).compareTo(new Integer(s1.age));
		if(num == 0) {
			return this.name.compareTo(s1.name);
		}
		return num;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

public class TestDemo2 {

	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<Student, String>();
		hm.put(new Student("lisi1",21),"beijing");
		hm.put(new Student("lisi1",21),"tianjin");
		hm.put(new Student("lisi2",22),"shanghai");
		hm.put(new Student("lisi3",23),"nanjing");
		hm.put(new Student("lisi4",24),"wuhan");
		
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new MyCmp());
		tm.put(new Student("lisi1",21),"beijing");
		tm.put(new Student("lisi1",21),"tianjin");
		tm.put(new Student("lisi2",22),"shanghai");
		tm.put(new Student("lisi3",23),"nanjing");
		tm.put(new Student("lisi4",24),"wuhan");
		//方法1：
		Set<Student> keySet = hm.keySet();
		Iterator<Student> it = keySet.iterator();
		while(it.hasNext()) {
			Student s = (Student)it.next();
			String addr = hm.get(s);
			System.out.println(s.toString()+".."+addr);
		}
		//方法2：
		Set<Map.Entry<Student, String>> entries = hm.entrySet();
		Iterator<Map.Entry<Student, String>> it1 = entries.iterator();
		while(it1.hasNext()) {
			Map.Entry<Student, String> me = it1.next();
			Student s = me.getKey();
			String  addr = me.getValue();
			System.out.println(s.toString()+".."+addr);
		}
		
		System.out.println(tm);
	}

}
