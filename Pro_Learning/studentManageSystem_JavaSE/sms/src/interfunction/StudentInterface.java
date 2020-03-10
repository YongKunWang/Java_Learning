package interfunction;

import java.util.ArrayList;

import domain.Student;

/**
 * ʹ�ýӿڶ��幦��
 * 
 * 	1. ��������ѧ������Ϣ
 * 	2. ���ѧ����Ϣ
 * 	3. ����ѧ�Ų���ѧ��
 * 	4. �������ֲ���ѧ��
 * 	5. ����ѧ��ɾ��ѧ��
 * 	6. ����ѧ���޸�ѧ��
 * @author asdw1
 *
 */

public interface StudentInterface {
	
	/**
	 * ��������ѧ��
	 */
	void showAll();
	/**
	 * ���ѧ����Ϣ
	 * @return
	 */
	boolean addStudent();
	/**
	 * ͨ��ѧ�Ų���ѧ��
	 * @param sid
	 * @return ����ҵ�����ѧ��ʵ�壬���û�ҵ�����null
	 */
	Student findStudentBySid(int sid);
	
	/**
	 * ͨ����������ѧ��
	 * @param name
	 * @return �ҵ�����һ��List���ϣ�δ�ҵ�����null
	 */
	ArrayList<Student> findStudentByName(String sname);
	/**
	 * ͨ��ѧ���Ƴ�ѧ��
	 * @param sid
	 * @return �Ƴ��ɹ�����true �Ƴ�ʧ�ܷ���false
	 */
	boolean removeStudentBySid(int sid);
	/**
	 * ͨ��ѧ���޸�ѧ��
	 * @param sid
	 * @return �޸ĳɹ�����true �޸�ʧ�ܻ���δ�ҵ�����false
	 */
	boolean modifyStudentBySid(int sid);
}

/**
 * �ܽ᣺
 * 	1. �����ܽ��з�װΪ�ӿ�
 */

