package function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import domain.Gender;
import domain.Student;
import interfunction.StudentInterface;
import utils.MyUtils;

public class StudentManageSystem implements StudentInterface {
	
	private Map<Integer,Student> students = new HashMap<Integer, Student>();
	private Scanner scanner = new Scanner(System.in);
	
	public void welcome() {
		System.out.println("---------��ӭ����ѧ���ɼ�����ϵͳ-----------");
		System.out.println("ϵͳ��ʼ���ɹ�...");
	}
	public void exit() {
		System.out.println("---------ллʹ��ѧ���ɼ�����ϵͳ-----------");
	}
	
	public void showMenu() {
		System.out.println("��ѡ�����Ĳ�����");
		System.out.println("* * 1. ��������ѧ�� ");
		System.out.println("* * 2. ���ѧ����Ϣ ");
		System.out.println("* * 3. ����ѧ�Ų���");
		System.out.println("* * 4. �������ֲ��� ");
		System.out.println("* * 5. ����ѧ��ɾ��");
		System.out.println("* * 6. ����ѧ���޸� ");
		System.out.println("* * 6. �˳�����ϵͳ");
	}
	
	
	@Override
	public void showAll() {
		
		if(students.isEmpty()) {
			System.out.println("�����ѧ����Ϣ...");
			return;
		}
		
		Set<Integer> keySet = students.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			Integer sid = iterator.next();
			Student student = students.get(sid);
			System.out.println(student);
		}
		
	}

	@Override
	public boolean addStudent() {
		int sid = MyUtils.getInputNumber("������ѧ����ѧ�ţ�Ҫ��������", scanner);
		String sname = MyUtils.getInputString("������ѧ��������", scanner);
		int age = MyUtils.getInputNumber("������ѧ�������䣬Ҫ��������", scanner);
		Gender gender = MyUtils.getInputString("������ѧ�����Ա�Ҫ���ǣ���|Ů��", scanner).equals("��")? Gender.�� : Gender.Ů;
		
		Student student = new Student(sid,sname,age,gender);
		students.put(sid, student);
		System.out.println("���ѧ���ɹ���");
		
		
		return true;
		
	}

	@Override
	public Student findStudentBySid(int sid) {
		
		Student student = students.get(sid);
		if(student != null)
			System.out.println(student);
		else
			System.out.println("��ѧ�Ų�����");
		return student;
	}
	/**
	 * ��������д
	 * ����д��������Ӽ�������
	 * Ϊ�˲��ٲ��Գ�������д̫��Ĵ�����
	 * @return
	 */
	public Student findStudentBySid() {
		
		int sid = MyUtils.getInputNumber("��������Ҫ���ҵ�ѧ�ţ�", scanner);
		
		return findStudentBySid(sid);
	}
	

	@Override
	public ArrayList<Student> findStudentByName(String sname) {
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		
		Collection<Student> values = students.values();
		Iterator<Student> iterator = values.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getName().equals(sname)) {
				arrayList.add(student);
			}
		}
		
		return arrayList.size() == 0?null:arrayList;
		
		
	}
	public void findStudentByName() {
		
		String sname = MyUtils.getInputString("��������Ҫ���ҵ����֣�", scanner);
		
		ArrayList<Student> arrayList =  findStudentByName(sname);
		
		if(arrayList == null) {
			System.err.println("�޴�ѧ����Ϣ");
		}
		else {
			for(Iterator<Student> iterator = arrayList.iterator(); iterator.hasNext();) {
				System.out.println((Student)iterator.next());
			}
		}
	
	}

	@Override
	public boolean removeStudentBySid(int sid) {
		
		Student student = students.remove(sid);
		
		return student == null? false:true;
		
		
	}
	
	public void removeStudentBySid() {
		
		int sid = MyUtils.getInputNumber("��������Ҫɾ����ѧ�ţ�", scanner);
		
		boolean bool =  removeStudentBySid(sid);
		if(bool) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ�����ɹ�");
		}
	}

	@Override
	public boolean modifyStudentBySid(int sid) {
		Student student = students.get(sid);
		
		if(student != null) {
			int id = MyUtils.getInputNumber("������ѧ����ѧ�ţ�Ҫ��������", scanner);
			String sname = MyUtils.getInputString("������ѧ��������", scanner);
			int age = MyUtils.getInputNumber("������ѧ�������䣬Ҫ��������", scanner);
			Gender gender = MyUtils.getInputString("������ѧ�����Ա�Ҫ���ǣ���|Ů��", scanner).equals("��")? Gender.�� : Gender.Ů;
			
			student.setSid(id);
			student.setName(sname);
			student.setAge(age);
			student.setGender(gender);
		}
		
		return student == null ? false : true;
		
	}
	public void modifyStudentBySid() {
		
		int sid = MyUtils.getInputNumber("��������Ҫ�޸ĵ�ѧ�ţ�", scanner);
		
		boolean bool = modifyStudentBySid(sid);
		if(bool) {
			System.out.println("�޸�ѧ����Ϣ�ɹ�");
		}else {
			System.out.println("�޸�ѧ����Ϣʧ��");
		}
		
	}
}

/**
 * �ܽ᣺
 * 	1. ʹ�����ػ��ƣ�����
 * 	2. ������������Ĵ��룡����
 */

