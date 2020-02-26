package fanxing1;
/**
 * 使用泛型的例子
 * Interface Comperator<T>
 * int compare(<T> o1, <T> o2){}
 * @author asdw1
 *
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {
	public int compare(String object1,String object2) {
		int num = new Integer(object1.length()).compareTo(new Integer(object2.length()));
		if(num == 0) {
			return object1.compareTo(object2);
		}
		return num;
	}
}

public class TestDemo2 {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>(new MyCompare());
		treeSet.add("J");
		treeSet.add("Ja");
		treeSet.add("ja");
		treeSet.add("Jav");
		
		for(Iterator<String> it = treeSet.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
