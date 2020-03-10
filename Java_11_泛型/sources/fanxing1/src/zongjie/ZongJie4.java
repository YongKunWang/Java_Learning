package zongjie;
/**
 * 泛型出现前和泛型出现后的区别
 * 泛型类的简单使用
 * @author asdw1
 */

class Tool {
	private Object obj;
	Tool(Object obj){
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}
}
class Worker {
	public void  show() {
		System.out.println("我在工作中...");
	}
}
class Student {
	public void  show() {
		System.out.println("我在学习中...");
	}
}

class Utils <T> {
	private T obj;
	Utils(T obj){
		this.obj = obj;
	}
	public T getObj() {
		return obj;
	}
}

public class ZongJie4 {

	public static void main(String[] args) {
		Tool t = new Tool(new Worker());
		Worker w1 = (Worker)t.getObj();
		w1.show();
		//类型转换异常
//		Student s1 = (Student)t.getObj();
//		s1.show();
		
		
		/* 1. 将运行时期错误转移到编译时期
		 * 2. 减少了运行时期的程序错误，安全
		 * 3. 避免了强制转型
		 */
		Utils<Worker> u1 = new Utils(new Worker());
		u1.getObj().show();
	}

}
