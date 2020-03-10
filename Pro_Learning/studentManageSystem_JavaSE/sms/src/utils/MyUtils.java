package utils;

import java.util.Scanner;

/**
 * ������
 * @author asdw1
 *
 */

public class MyUtils {
	
	public MyUtils() {}
	
	/**
	 * ���һ�������
	 * @param min ����
	 * @param max ������
	 * @return ����һ�������
	 */
	public static int getRandomNumber(int min, int max) {
		
		return (int)(Math.random()*(max-min) + min);
	}
	
	/**
	 * ���û���ʾ��Ϣ��ͬʱ�����û�����һ���ַ���
	 * @param msg
	 * @param scanner
	 * @return ����һ������
	 */
	public static int getInputNumber(String msg, Scanner scanner) {
		System.out.println(msg);
		return scanner.nextInt();
	}
	/**
	 * ���û���ʾ��Ϣ��ͬʱ�����û�����һ���ַ���
	 * @param msg
	 * @param scanner
	 * @return �����ַ���
	 */
	public static String getInputString(String msg, Scanner scanner) {
		System.out.println(msg);
		return scanner.next();
	}
}
