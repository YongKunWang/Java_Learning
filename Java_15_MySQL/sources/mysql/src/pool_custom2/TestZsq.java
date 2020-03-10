package pool_custom2;
/*
 * 1. 测试装饰器模式
 */

class Person {
	public void eat() {
		System.out.println("eat...");
	}
}

class SuperPerson {
	private Person person;
	public SuperPerson(Person person) {
		this.person = person;
	}
	public void eat() {
		person.eat();
		System.out.println("Drinking...");
	}
}


public class TestZsq {

	public static void main(String[] args) {
		SuperPerson person = new SuperPerson(new Person());
		person.eat();

	}

}
