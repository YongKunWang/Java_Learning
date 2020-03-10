package interfunction;

import java.util.ArrayList;

import domain.Student;

/**
 * 使用接口定义功能
 * 
 * 	1. 遍历所有学生的信息
 * 	2. 添加学生信息
 * 	3. 根据学号查找学生
 * 	4. 根据名字查找学生
 * 	5. 根据学号删除学生
 * 	6. 根据学号修改学生
 * @author asdw1
 *
 */

public interface StudentInterface {
	
	/**
	 * 遍历所有学生
	 */
	void showAll();
	/**
	 * 添加学生信息
	 * @return
	 */
	boolean addStudent();
	/**
	 * 通过学号查找学生
	 * @param sid
	 * @return 如果找到返回学生实体，如果没找到返回null
	 */
	Student findStudentBySid(int sid);
	
	/**
	 * 通过姓名查找学生
	 * @param name
	 * @return 找到返回一个List集合，未找到返回null
	 */
	ArrayList<Student> findStudentByName(String sname);
	/**
	 * 通过学号移除学生
	 * @param sid
	 * @return 移除成功返回true 移除失败返回false
	 */
	boolean removeStudentBySid(int sid);
	/**
	 * 通过学号修改学生
	 * @param sid
	 * @return 修改成功返回true 修改失败或者未找到返回false
	 */
	boolean modifyStudentBySid(int sid);
}

/**
 * 总结：
 * 	1. 将功能进行封装为接口
 */

