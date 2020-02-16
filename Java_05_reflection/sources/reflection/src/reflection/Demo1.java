package reflection;

import reflection.Work;
import reflection.Student;

import java.lang.reflect.Field;

/**
 * 获取Class对象的方法：
 * 	1. 字节码：
 * 		Class.forName("全类名(最好使用复制的方法)");
 * 			此方法将字节码文件加载进入内存，返回Class对象
 * 	2. 字节码加载进入内存
 * 		Class.class
 * 			通过类名的属性class获取
 * 	3. 已生成实例对象
 * 		Instance.getClass()
 * 			getClass()方法在Object类中定义着
 *
 */


public class Demo1 {

	public static void main(String[] args) throws Exception {
		System.out.println("--------使用三种方法实现对象的获取----------");
		Class cls1 = Class.forName("reflection.Work");
		System.out.println(cls1);
		
		Class cls2 = Work.class;
		System.out.println(cls2);
		
		Work work = new Work("wyk1",19,"男","1001");
		Class cls3 = work.getClass();
		System.out.println(cls3);
		System.out.println("==========================");
//		获取所有被public所修饰的类变量
		Field[] fields = cls1.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println("--------------------");
		Field name = cls3.getField("name");
		System.out.println(name);
		Work work2 = new Work("wyk1",19,"男","1001");
		Object value = name.get(work2);
		System.out.println(value);
		name.set(work2, "Wyk3");
		work2.show();
	}

}
