package mysql1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 1. 单元测试的内容
 * 		在使用单元测试试，会自动引入Junit4的包，直接鼠标添加即可
 * 		在进行程序调试的时候直接调试@Test的函数即可
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		System.out.println("主函数输出语句...");
	}
	@Test
	public void testJunit() {
		System.out.println("Test输出...");
	}
	@Before
	public void testBefore() {
		System.out.println("TestBefore输出...");
	}
	@After
	public void testAfter() {
		System.out.println("TestAfter输出...");
	}
}

