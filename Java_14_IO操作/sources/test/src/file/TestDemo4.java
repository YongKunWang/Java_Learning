package file;
/**
 * ×°ÊÎÆ÷Ä£Ê½
 * @author asdw1
 *
 */

class Person {
	public void eat() {
		System.out.println("eat...");
	}
}
class SuperPerson {
	private Person person;
	public SuperPerson(Person person) {
		super();
		this.person = person;
	}
	public void eat() {
		System.out.println("eat...");
		System.out.println("Drinking...");
	}
}
public class TestDemo4 {

	public static void main(String[] args) {
		Person person = new Person();
		person.eat();
		SuperPerson superPerson = new SuperPerson(new Person());
		superPerson.eat();

	}

}
