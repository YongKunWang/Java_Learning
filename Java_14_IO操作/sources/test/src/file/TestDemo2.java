package file;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * �ַ����ļ����Ʋ���
 * �ȴ򿪵��ȹر�
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
			//��һ����дһ��
//			for(int ch = fr.read(); ch != -1; ch = fr.read())
//				fw.write(ch);
			
			//��һ�� дһ��
			char[] buff = new char[1024];
			int num = 0;
			while((num = fr.read(buff))!= -1) {
				fw.write(buff,0,num);
				//��ӡ������̨��
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
