package other;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.text.*;

/**
 * 1. ��ȡ�쳣��Ϣ��ָ��λ��
 * @author asdw1
 *
 */
public class TestDemo4 {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			int[] arr = new int[2];
			System.out.println(arr[3]);
		} catch (Exception e) {
			try {
				Date date = new Date();
				System.setOut(new PrintStream("exlog.txt"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str = sdf.format(date);
				System.out.println(str);
			} catch (Exception e2) {
				throw new RuntimeException("�쳣�ļ�����ʧ��");
			}
			e.printStackTrace(System.out);
		}
		
	}

}
