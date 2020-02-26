package fanxing1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1. ArrayList之泛型的使用
 * 		想要使用1个函数显示不同的数据类型
 * 		使用<?>通配符！！
 * 2. 我想要一个函数显示Person类的所有子类
 * 		使用泛型限定之上限
 * 3. 我想要TreeSet使用一个通用的比较器
 * @author asdw1
 *
 */

class Personn {
	private String name;
	private int age;
	public Personn(String name, int age) {
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
	
}
class Workerr extends Personn {
	public Workerr(String name, int age) {
		super(name,age);
	}
	
}

class Studentt extends Personn {
	public Studentt(String name, int age) {
		super(name,age);
	}
}

class MyCmpS implements Comparator<Studentt> {
	public int compare(Studentt studentt1, Studentt studentt2) {
		return 1;
	}
}
class MyCmpW implements Comparator<Workerr> {
	public int compare(Workerr workerr1, Workerr workerr2) {
		return 1;
	}
}

class MyCmp implements Comparator<Personn>{
	public int compare(Personn personn1,Personn personn2) {
		return -1;
	}
}
public class TestDemo6 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		printColl(al);
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(4);
		al1.add(7);
		al1.add(1);
		printColl(al1);
		
		
		ArrayList<Personn> p1 = new ArrayList<Personn>();
		p1.add(new Personn("abc1",11));
		p1.add(new Personn("abc2",12));
		p1.add(new Personn("abc3",13));
		printColll(p1);

		ArrayList<Studentt> p11 = new ArrayList<Studentt>();
		p11.add(new Studentt("abc--1",22));
		p11.add(new Studentt("abc--2",23));
		p11.add(new Studentt("abc--3",24));
		printColll(p11);  
		
		TreeSet<Studentt> ts = new TreeSet<Studentt>(new MyCmp());

		ts.add(new Studentt("abc03",31));
		ts.add(new Studentt("abc02",32));
		ts.add(new Studentt("abc06",33));
		ts.add(new Studentt("abc01",34));
		
		Iterator<Studentt> it = ts.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}
		/**/



		TreeSet<Workerr> ts1 = new TreeSet<Workerr>(new MyCmp());

		ts1.add(new Workerr("wabc--03",1));
		ts1.add(new Workerr("wabc--02",2));
		ts1.add(new Workerr("wabc--06",3));
		ts1.add(new Workerr("wabc--01",4));


		Iterator<Workerr> it1 = ts1.iterator();

		while(it1.hasNext())
		{
			System.out.println(it1.next().getName());
		}
	}
	public static void printColl(ArrayList<?> al){
		
		Iterator<?> it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public static void printColll(Collection<? extends Personn> p1) {
		Iterator<? extends Personn> it = p1.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
	}

}


