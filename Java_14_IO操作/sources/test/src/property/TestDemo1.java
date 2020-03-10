package property;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
Properties是hashtable的子类。
也就是说它具备map集合的特点。而且它里面存储的键值对都是字符串。

是集合中和IO技术相结合的集合容器。

该对象的特点：可以用于键值对形式的配置文件。

那么在加载数据时，需要数据有固定格式：键=值。
 */

public class TestDemo1 {
	public static void main(String[] args) throws IOException{
//		setAndGet();
//		method1();
		method2();
	} 
	//使用properties的方法读取和保存配置文件
	public static void method2() throws IOException{
		Properties pr = new Properties();
		FileInputStream fr = new FileInputStream("info.txt");

		pr.load(fr);
		System.out.println(pr);
		pr.setProperty("aaa", "70");
		//这个位置有讲究的！！！！！！！！！！！
		FileOutputStream fw = new FileOutputStream("info.txt");
		pr.store(fw,"haha");
		pr.list(System.out);
		fw.close();
		fr.close();
	}
	//从文件读取配置文件
	public static void method1() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("info.txt"));
		
		String line = null;
		Properties pr = new Properties();
		while((line = br.readLine()) != null) {
			String[] arr = line.split("=");
			pr.setProperty(arr[0], arr[1]);
		}
		System.out.println(pr);
		br.close();
	
	}
	
	//初始化并且遍历
	public static void setAndGet() {
		Properties pr = new Properties();
		pr.setProperty("zhangsan", "30");
		pr.setProperty("lisi", "40");
		
		System.out.println(pr);
		
		System.out.println(pr.getProperty("lisi"));
		
		//遍历
		Set<String> names = pr.stringPropertyNames();
		for(String s : names)
			System.out.println(s +" : "+ pr.getProperty(s));

	}
}
