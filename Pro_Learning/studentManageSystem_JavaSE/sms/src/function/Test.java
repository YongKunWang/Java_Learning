package function;

import java.util.Scanner;

import utils.MyUtils;

public class Test {

	public static void main(String[] args) {
		StudentManageSystem system = new StudentManageSystem();
			
		system.welcome();
		Scanner in = new Scanner(System.in);
		
		while(true) {
			system.showMenu();
			int input = MyUtils.getInputNumber("��ѡ�����Ĳ���:", in);
			
			switch (input) {
			case 1:
				system.showAll();
				break;
			case 2:
				system.addStudent();
				break;
			case 3:
				system.findStudentBySid();
				break;
			case 4:
				system.findStudentByName();
				break;
			case 5:
				system.removeStudentBySid();
				break;
			case 6:
				system.modifyStudentBySid();
				break;
			case 7:
				system.exit();
				return ;
			default:
				System.out.println("���������Ϣ��������������...");
				break;
			}
		}
		

	}

}
