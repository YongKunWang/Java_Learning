package file;

import java.io.File;
import java.io.FileWriter;

/**
 * 1. 输入数据到文件中 使用字符流
 * @author asdw1
 *
 */

public class TestDemo1 {

	public static void main(String[] args) {
		//变量的指向必须给定！！
		FileWriter fw = null;
		String str = "\"Hello World!!\"";
		try {
			fw = new FileWriter("test1.txt");
//			fw = new FileWriter("src");
			fw.write(str.toCharArray());
			fw.write("\r\n");
			fw.write(str.toCharArray(),0,10);
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fw != null)
					fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
