package zongjie;
/**
 * 1.一个在编译阶段检测不出而在运行阶段的类型转换异常
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ZongJie1 {

	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		arr.add("Java01");
		arr.add(4);
		arr.add(new Integer(5));
		
		for(Iterator it = arr.iterator(); it.hasNext();) {
			String str = (String)it.next();
			System.out.println(str.length());
		}
	}
}
