package collections;
/**
 * 当类名重名时，需要指定具体的包名。
	当方法重名是，指定具备所属的对象或者类。
 */
import java.util.*;
import static java.util.Arrays.*;

/**
 * 静态导入
 * @author asdw1
 *
 */
public class TestDemo6 {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		//必须增加，因为在Object中有这个方法
		System.out.println(Arrays.toString(arr));
		
	}

}
