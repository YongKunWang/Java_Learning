package other;

import java.io.IOException;
import java.io.InputStream;

/*
 * 读取键盘录入：
 * 
 * System.out:对应的是标准输出设备，控制台。
 * System.in:对应的标准输入设备：键盘。
 * 需求：
	通过键盘录入数据。
	当录入一行数据后，就将该行数据进行打印。
	如果录入的数据是over，那么停止录入。
 */
public class TestDemo1 {

	public static void main(String[] args) throws IOException{
		InputStream ins = System.in;
		StringBuilder sbr = new StringBuilder();
		
		while(true) {
			int ch = ins.read();
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n') {
				String str = sbr.toString();
				if("over".equals(str))
					break;
				System.out.println(str.toUpperCase());
				sbr.delete(0, sbr.length());
			}
			else {
				sbr.append((char)ch);
			}
		}

	}

}
