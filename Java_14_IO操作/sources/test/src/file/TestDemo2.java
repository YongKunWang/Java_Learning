package file;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流文件复制操作
 * 先打开的先关闭
 * @author asdw1
 *
 */
public class TestDemo2 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fr = new FileReader("test1.txt");
			fw = new FileWriter("dsc.txt");
			//读一个，写一个
//			for(int ch = fr.read(); ch != -1; ch = fr.read())
//				fw.write(ch);
			
			//读一坨 写一坨
			char[] buff = new char[1024];
			int num = 0;
			while((num = fr.read(buff))!= -1) {
				fw.write(buff,0,num);
				//打印到控制台上
				System.out.println(new String(buff,0,num));
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
