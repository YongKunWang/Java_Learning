package zijie;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 复制大文件的操作
 */
public class TestDemo3 {

	public static void main(String[] args) {
		BufferedInputStream bfi = null;
		BufferedOutputStream bfo = null;
		try {
			bfi = new BufferedInputStream(new FileInputStream("test.avi"));
			bfo = new BufferedOutputStream(new FileOutputStream("dsc.avi"));
			
			int by = 0;
			while((by = bfi.read()) != -1) {
				bfo.write(by);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				bfo.close();
				bfi.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
