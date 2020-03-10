package zijie;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * ¸´ÖÆÍ¼Æ¬
 */
public class TestDemo2 {

	public static void main(String[] args) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("test.png");
			fo = new FileOutputStream("dsc.png");
			byte[] buff = new byte[1024];
			int len = 0;
			while((len = fi.read(buff))!= -1) {
				fo.write(buff,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fo.close();
				fi.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
