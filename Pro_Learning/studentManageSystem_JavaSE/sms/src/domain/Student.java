package domain;


/**
 * 学生实体类：
 * 	1. 学号
 * 	2. 姓名
 * 	3. 年龄
 * 	4. 性别
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
		return "Student [学号=" + sid + ", 姓名=" + name + ", 年龄=" + age + ", 性别=" + gender + "]";
	}
}

/**
 * 总结：
 * 	1. 定义实体类的过程
 * 	2. 枚举的使用
 */


