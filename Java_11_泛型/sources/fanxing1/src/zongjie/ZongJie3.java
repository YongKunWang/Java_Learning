package zongjie;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1.泛型类的使用
 * 		以TreeSet的比较器为例子
 * @author asdw1
 *
 */ 

class MyCmp implements Comparator<String> {
	public int compare(String str1,String str2) {
		return str2.compareTo(str1);
	}
}

public class ZongJie3 {

	public static void main(String[] args) {
		TreeSet<String> tr = new TreeSet<String>(new MyCmp());
		tr.add("Java01");
		tr.add("Javao2");
		tr.add("Javao3");
		tr.add("Javao4");
		tr.add("Javao5");
		
		for(Iterator<String> it = tr.iterator(); it.hasNext();) {
			System.err.println(it.next());
		}
	}

}
