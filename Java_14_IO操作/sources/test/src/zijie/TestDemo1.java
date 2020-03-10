package zijie;

import java.io.*;

/**
 * 字节流对象
 * 1. 字符流和字节流关于刷新的不同：
 * 		字符流采用两个字节处理，需要进行写入刷新
 * 		字节流只是字节操作，遇见一个字节操作一个字节，不用刷新
 * 		字节流涉及缓冲区才可以刷新
 * 2. 关于字节流缓冲区的问题：
 * 		缓冲区调用fileInputStream的read方法从硬盘来获得一批数据到内存
 * 		的缓冲区中，缓冲区的read函数从内存中一个字节一个字节的读！
 * @author asdw1
 *
 */
public class TestDemo1 {

	public static void main(String[] args) {
		write();
		read1();
		read2();
		
	}
	public static void write() {
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("a.txt");
			fo.write("abcd".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void read1() {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("a.txt");
			int ch = 0;
			while((ch = fi.read()) != -1)
				System.out.println((char)ch);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static void read2() {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("a.txt");
			byte[] buff = new byte[1024];
			int len = 0;
			while((len = fi.read(buff)) != -1)
				System.out.println(new String(buff,0,len));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
