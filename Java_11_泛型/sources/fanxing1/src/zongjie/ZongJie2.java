package zongjie;
/**
 * 1.一个在编译阶段检测不出而在运行阶段的类型转换异常
 * 2. 借鉴数组的处理方法，解决问题1
 * 		好处：
 * 			将运行时错误，转移到了编译时期
 * 			避免了数据强制转换的麻烦
 * 			方便程序员解决问题，让运行时问题减少
 * 3. 泛型的格式：
 * 		大括号 中括号 小括号都被用了，只能使用尖括号了！	
 * 4. 当添加泛型以后，IDE环境下，程序在编写时期就会自动的报错！！
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ZongJie2 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Java01");
//		arr.add(4);
//		arr.add(new Integer(5));
		
		for(Iterator<String> it = arr.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
