package zijie;

import java.io.*;

/**
 * �ֽ�������
 * 1. �ַ������ֽ�������ˢ�µĲ�ͬ��
 * 		�ַ������������ֽڴ�����Ҫ����д��ˢ��
 * 		�ֽ���ֻ���ֽڲ���������һ���ֽڲ���һ���ֽڣ�����ˢ��
 * 		�ֽ����漰�������ſ���ˢ��
 * 2. �����ֽ��������������⣺
 * 		����������fileInputStream��read������Ӳ�������һ�����ݵ��ڴ�
 * 		�Ļ������У���������read�������ڴ���һ���ֽ�һ���ֽڵĶ���
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
