package other;

import java.io.IOException;
import java.io.InputStream;

/*
 * ��ȡ����¼�룺
 * 
 * System.out:��Ӧ���Ǳ�׼����豸������̨��
 * System.in:��Ӧ�ı�׼�����豸�����̡�
 * ����
	ͨ������¼�����ݡ�
	��¼��һ�����ݺ󣬾ͽ��������ݽ��д�ӡ��
	���¼���������over����ôֹͣ¼�롣
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
