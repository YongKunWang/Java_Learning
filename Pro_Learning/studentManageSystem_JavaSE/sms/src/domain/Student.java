package domain;


/**
 * ѧ��ʵ���ࣺ
 * 	1. ѧ��
 * 	2. ����
 * 	3. ����
 * 	4. �Ա�
 * @author asdw1
 *
 */


public class Student {
	
	private Integer sid;
	private String name;
	private int age;
	private Gender gender;
	
	public Student() {
		super();
	}

	public Student(Integer sid, String name, int age, Gender gender) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [ѧ��=" + sid + ", ����=" + name + ", ����=" + age + ", �Ա�=" + gender + "]";
	}
}

/**
 * �ܽ᣺
 * 	1. ����ʵ����Ĺ���
 * 	2. ö�ٵ�ʹ��
 */


