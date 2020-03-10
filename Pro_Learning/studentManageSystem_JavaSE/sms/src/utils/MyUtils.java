package utils;

import java.util.Scanner;

/**
 * 工具类
 * @author asdw1
 *
 */

public class MyUtils {
	
	public MyUtils() {}
	
	/**
	 * 获得一个随机数
	 * @param min 包括
	 * @param max 不包括
	 * @return 返回一个随机数
	 */
	public static int getRandomNumber(int min, int max) {
		
		return (int)(Math.random()*(max-min) + min);
	}
	
	/**
	 * 给用户提示信息的同时，请用户输入一个字符串
	 * @param msg
	 * @param scanner
	 * @return 返回一个整数
	 */
	public static int getInputNumber(String msg, Scanner scanner) {
		System.out.println(msg);
		return scanner.nextInt();
	}
	/**
	 * 给用户提示信息的同时，请用户输入一个字符串
	 * @param msg
	 * @param scanner
	 * @return 返回字符串
	 */
	public static String getInputString(String msg, Scanner scanner) {
		System.out.println(msg);
		return scanner.next();
	}
}
