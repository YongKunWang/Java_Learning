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
		System.out.println("---------欢迎来到学生成绩管理系统-----------");
		System.out.println("系统初始化成功...");
	}
	public void exit() {
		System.out.println("---------谢谢使用学生成绩管理系统-----------");
	}
	
	public void showMenu() {
		System.out.println("请选择您的操作：");
		System.out.println("* * 1. 遍历所有学生 ");
		System.out.println("* * 2. 添加学生信息 ");
		System.out.println("* * 3. 根据学号查找");
		System.out.println("* * 4. 根据名字查找 ");
		System.out.println("* * 5. 根据学号删除");
		System.out.println("* * 6. 根据学号修改 ");
		System.out.println("* * 6. 退出管理系统");
	}
	
	
	@Override
	public void showAll() {
		
		if(students.isEmpty()) {
			System.out.println("请添加学生信息...");
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
		int sid = MyUtils.getInputNumber("请输入学生的学号，要求是整数", scanner);
		String sname = MyUtils.getInputString("请输入学生的姓名", scanner);
		int age = MyUtils.getInputNumber("请输入学生的年龄，要求是整数", scanner);
		Gender gender = MyUtils.getInputString("请输入学生的性别，要求是（男|女）", scanner).equals("男")? Gender.男 : Gender.女;
		
		Student student = new Student(sid,sname,age,gender);
		students.put(sid, student);
		System.out.println("添加学生成功！");
		
		
		return true;
		
	}

	@Override
	public Student findStudentBySid(int sid) {
		
		Student student = students.get(sid);
		if(student != null)
			System.out.println(student);
		else
			System.out.println("该学号不存在");
		return student;
	}
	/**
	 * 方法的重写
	 * 在重写方法中添加键盘输入
	 * 为了不再测试程序中书写太多的代码量
	 * @return
	 */
	public Student findStudentBySid() {
		
		int sid = MyUtils.getInputNumber("请输入你要查找的学号：", scanner);
		
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
		
		String sname = MyUtils.getInputString("请输入你要查找的名字：", scanner);
		
		ArrayList<Student> arrayList =  findStudentByName(sname);
		
		if(arrayList == null) {
			System.err.println("无此学生信息");
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
		
		int sid = MyUtils.getInputNumber("请输入你要删除的学号：", scanner);
		
		boolean bool =  removeStudentBySid(sid);
		if(bool) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除不成功");
		}
	}

	@Override
	public boolean modifyStudentBySid(int sid) {
		Student student = students.get(sid);
		
		if(student != null) {
			int id = MyUtils.getInputNumber("请输入学生的学号，要求是整数", scanner);
			String sname = MyUtils.getInputString("请输入学生的姓名", scanner);
			int age = MyUtils.getInputNumber("请输入学生的年龄，要求是整数", scanner);
			Gender gender = MyUtils.getInputString("请输入学生的性别，要求是（男|女）", scanner).equals("男")? Gender.男 : Gender.女;
			
			student.setSid(id);
			student.setName(sname);
			student.setAge(age);
			student.setGender(gender);
		}
		
		return student == null ? false : true;
		
	}
	public void modifyStudentBySid() {
		
		int sid = MyUtils.getInputNumber("请输入你要修改的学号：", scanner);
		
		boolean bool = modifyStudentBySid(sid);
		if(bool) {
			System.out.println("修改学生信息成功");
		}else {
			System.out.println("修改学生信息失败");
		}
		
	}
}

/**
 * 总结：
 * 	1. 使用重载机制！！！
 * 	2. 减少了主程序的代码！！！
 */

