package collections;


import java.util.*;

/**
 * 数组元素变为集合元素的优点：
 * 	方便进行查询操作
 * 	无法进行元素的增删操作
 * @author asdw1
 *
 */
public class TestDemo4 {

	public static void main(String[] args) {
		String[] str = {"111","222","333"};
		List<String> list = Arrays.asList(str);
		System.out.println(list);
		
		int[] in = {111,222,333};
		List<int[]> list2 = Arrays.asList(in);
		System.out.println(list2);
		
		Integer[] in1 = {111,222,333};
		List<Integer> list3 = Arrays.asList(in1);
		System.out.println(list3);
		
		/*
		 * 如果数组中元素为引用类型，那么变成集合时，数组中的元素就直接转换为集合中的元素
		 * 如果数组中的元素都是基本数据类型，那么会将该数组变为集合中的元素存在
		 * */
	}

}
