package collections;
/**
 * ����������ʱ����Ҫָ������İ�����
	�����������ǣ�ָ���߱������Ķ�������ࡣ
 */
import java.util.*;
import static java.util.Arrays.*;

/**
 * ��̬����
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
		//�������ӣ���Ϊ��Object�����������
		System.out.println(Arrays.toString(arr));
		
	}

}
