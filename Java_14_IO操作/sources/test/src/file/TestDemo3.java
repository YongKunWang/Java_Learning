package file;
/**
 * 缓冲区技术
 * 为了提高效率。加入缓冲技术。
 * 将字符读取流对象作为参数传递给缓冲对象的构造函数。
 * 自己实现了BufferedReader.readLine()的方法
 * 使用StringBuilder是因为这是一个可变长度的字符系列，线程不同步，效率高
 * @author asdw1
 *
 */
import java.io.*;

class MyBufferedReader {
	private FileReader fr = null;
	public MyBufferedReader(FileReader fr) {
		super();
		this.fr = fr;
	}
	
	public String myReadLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		//遇到回车时的办法
		while((ch = fr.read()) != -1) {
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n')
				return sb.toString();
			else 
				sb.append((char)ch);
		}
		//一行无回车时的办法
		if(sb.length() != 0)
			return sb.toString();
		return null;
	}
	
	public void myClose() throws IOException {
		fr.close();
	}
}


public class TestDemo3 {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		MyBufferedReader mbr = null;
		try {
			fr = new FileReader("test1.txt");
			fw = new FileWriter("dsc.txt");
			bw = new BufferedWriter(fw);
			br = new BufferedReader(fr);
			mbr = new MyBufferedReader(fr);
			String str = null;
			//readLine方法返回的时候只返回回车符之前的数据内容，并不返回回车符
			while((str = mbr.myReadLine()) != null) {
				bw.write(str);
				//提供了一个跨平台的换行符
				bw.newLine();
				//记住，只要用到缓冲区，就要记得刷新!!
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//关闭缓冲区，就是关闭缓冲区中的流对象
				br.close();
				bw.close();
				mbr.myClose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
