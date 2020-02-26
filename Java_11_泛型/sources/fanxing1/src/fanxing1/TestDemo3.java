package fanxing1;

/**
 * 1. 出现泛型前和出现泛型后的区分
 * 		定义工具类Tool
 * 		工具类接收工人和学生
 * 		只能人工判断所传参数和转型的正确性，编译时无法确定
 * 2. 泛型的做法
 * 
 * @author asdw1
 *
 */

class Tool {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}

class Student {
	
}
class Worker{
	
}


class Utilss<T>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}


public class TestDemo3 {

	public static void main(String[] args) {
		Tool tool = new Tool();
		tool.setObject(new Student());
		Worker worker = (Worker)tool.getObject();
		
		Utilss<Worker> utilss = new Utilss<Worker>();
		utilss.setObj(new Worker());
		Worker worker2 = (Worker)utilss.getObj();

	}

}
