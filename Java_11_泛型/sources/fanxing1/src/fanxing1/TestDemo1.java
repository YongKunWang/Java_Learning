package fanxing1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1. 编译期间不出现问题，运行期间出现了类型转换异常
 * 2. 为了解决问题1，借鉴数组的处理方法(JDK1.5)
 * 3. 好处：
 * 		将运行时期出现问题ClassCastException，转移到了编译时期
 * 		方便于程序员解决问题。让运行时问题减少，安全。
 * 		避免了强制转换麻烦
 * 4. 泛型的格式：
 * 		使用<>来定义要操作的引用数据类型
 * 5. 什么时候写泛型呢？
 * 		通常在集合框架中很常见
 * 		只要见到<>就要定义泛型
 * @author asdw1
 *
 */

public class TestDemo1 {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Java01");
		arrayList.add("Java01");
		//arrayList.add(4);
		
		for(Iterator<String> it = arrayList.iterator();it.hasNext();) {
			System.out.println(it.next());
		}

	}

}
