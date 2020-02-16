package reflection;

public class Work {
	
	public String name;
	private int age;
	private String sex;
	private String addr;
	
//	构造函数
	public Work() {
		super();
	}

	public Work(String name, int age, String sex, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.addr = addr;
	}
	
	public void show() {
		System.out.println(this.getClass().getName() + " : " + this.name + " ： 我在工作中.....");
	}
	
//	设置和查询
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
