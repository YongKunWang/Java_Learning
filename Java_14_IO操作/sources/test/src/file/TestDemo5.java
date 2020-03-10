package file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReaderµÄÓÃ·¨
 * @author asdw1
 *
 */
class MyLineNumberReader  {
	private FileReader fr;
	private int cnt = 0;
	public MyLineNumberReader(FileReader fr) {
		this.fr = fr;
	}
	public String myReadLine() throws IOException {
		cnt ++;
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = fr.read())!= -1) {
			if((char)ch == '\r')
				continue;
			else if((char)ch == '\n')
				return sb.toString();
			else 
				sb.append((char)ch);
		}
		if(sb.length() != 0)
			return sb.toString();
		return null;
	}
	public void mySetLineNumber(int cnt) {
		this.cnt = cnt;
	}
	public int myGetLineNumber(){
		return cnt;
	}
	public void close()throws IOException {
		fr.close();
	}
}

public class TestDemo5 {

	public static void main(String[] args) {
//		FileReader fr = null;
//		LineNumberReader lr = null;
//		try {
//			fr = new FileReader("./src/file/TestDemo4.java");
//			lr = new LineNumberReader(fr);
//			String str = null;
//			lr.setLineNumber(100);
//			while((str = lr.readLine()) != null) {
//				System.out.println(lr.getLineNumber()+" : " + str);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		FileReader fr = null;
		MyLineNumberReader lr = null;
		try {
			fr = new FileReader("./src/file/TestDemo4.java");
			lr = new MyLineNumberReader(fr);
			String str = null;
			lr.mySetLineNumber(100);
			while((str = lr.myReadLine()) != null) {
				System.out.println(lr.myGetLineNumber()+" : " + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				lr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
