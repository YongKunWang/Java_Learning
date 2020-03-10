package collections;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合变为数组
 * 1. 集合为什要变为数组？
 * 		为了对数据元素进行限定，无法进行数组元素的增删操作
 * 2. 指定类型的数组的长度为多少？
 * 		当指定类型的数组元素 < 集合的size时，该方法内部会创建一个新的数组，
 * 		长度为集合的size()
 * 		当指定类型的数组元素 > 集合的size时，就不会创建新的数组了，
 * 		而是使用传递进来的数组，且数组的多余元素为null
 * 
 * @author asdw1
 *
 */
public class TestDemo3 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Java01");
		arr.add("Java02");
		arr.add("Java03");
		
		
		String[] str = arr.toArray(new String[arr.size()]);
		System.out.println(str);
		for (String string : str) {
			System.out.println(string);
		}
	}

}
