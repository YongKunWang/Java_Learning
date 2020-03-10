package other;

import java.io.*;

/**
 * 1. 上述代码实现了字节流读取一行代码，发现代码就是字符流的读取一行的代码
 * 2. 我们能不能直接使用字符流的readLine方法来读取键盘录入
 * 3. 涉及字符流和字节流之间的转换
 * @author asdw1
 *
 */
public class TestDemo2 {

	public static void main(String[] args) throws IOException {
		
		myTransStreamReadLine();

	}
	
	public static void myInputStreamReadLine() throws IOException {
		
		InputStream ins = System.in;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int ch = ins.read();
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n') {
				String str = sb.toString();
				if("over".equals(str))
					break;
				System.out.println(str.toUpperCase());
				sb.delete(0, sb.length());
			}
			else {
				sb.append((char)ch);
			}
		}
	}
	
	public static void myTransStreamReadLine() throws IOException {
		InputStream ins = System.in;
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader br = new BufferedReader(isr);
		//常用写法
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String lineString = null;
		while((lineString = br.readLine()) != null) {
			if("over".equals(lineString))
				break;
			bw.write(lineString);
			bw.newLine();
			//必须要有刷新操作
			//字符流一定要刷新
			//字节流不需要刷新
			bw.flush();
		}
		bw.close();
	}

}
