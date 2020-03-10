package other;

import java.io.*;

/**
 * 1. ��������ʵ�����ֽ�����ȡһ�д��룬���ִ�������ַ����Ķ�ȡһ�еĴ���
 * 2. �����ܲ���ֱ��ʹ���ַ�����readLine��������ȡ����¼��
 * 3. �漰�ַ������ֽ���֮���ת��
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
		//����д��
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String lineString = null;
		while((lineString = br.readLine()) != null) {
			if("over".equals(lineString))
				break;
			bw.write(lineString);
			bw.newLine();
			//����Ҫ��ˢ�²���
			//�ַ���һ��Ҫˢ��
			//�ֽ�������Ҫˢ��
			bw.flush();
		}
		bw.close();
	}

}
