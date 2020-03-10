package file;
/**
 * ����������
 * Ϊ�����Ч�ʡ����뻺�弼����
 * ���ַ���ȡ��������Ϊ�������ݸ��������Ĺ��캯����
 * �Լ�ʵ����BufferedReader.readLine()�ķ���
 * ʹ��StringBuilder����Ϊ����һ���ɱ䳤�ȵ��ַ�ϵ�У��̲߳�ͬ����Ч�ʸ�
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
		//�����س�ʱ�İ취
		while((ch = fr.read()) != -1) {
			if((char)ch == '\r')
				continue;
			if((char)ch == '\n')
				return sb.toString();
			else 
				sb.append((char)ch);
		}
		//һ���޻س�ʱ�İ취
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
			//readLine�������ص�ʱ��ֻ���ػس���֮ǰ���������ݣ��������ػس���
			while((str = mbr.myReadLine()) != null) {
				bw.write(str);
				//�ṩ��һ����ƽ̨�Ļ��з�
				bw.newLine();
				//��ס��ֻҪ�õ�����������Ҫ�ǵ�ˢ��!!
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				//�رջ����������ǹرջ������е�������
				br.close();
				bw.close();
				mbr.myClose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
