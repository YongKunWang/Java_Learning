package fanxing1;

/**
 * 1. 泛型定义在接口上
 * 		接口明确了数据类型
 * 2. 接口类未明确接口类型
 * @author asdw1
 *
 */

interface Inter <T>{
	void show(T t);
}
/*实现类明确了数据类型*/
class InterImpl implements Inter<String>{
	public void show(String string) {
		System.out.println(string);
	}
}

/*接口类未明确接口类型*/
class InterImpll<T> implements Inter<T>{
	public void show(T t) {
		System.out.println(t);
	}
}

public class TestDemo5 {

	public static void main(String[] args) {
		InterImpl interImpl = new InterImpl();
		interImpl.show("dsds");
		InterImpll<Integer> interImpll = new InterImpll<Integer>();
		interImpll.show(123);
		
	}

}
