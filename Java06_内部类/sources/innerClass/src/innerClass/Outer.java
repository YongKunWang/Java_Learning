package innerClass;

public class Outer {
	
	private int num = 31;
	
	static class Inner {
		public void show() {
			System.out.println("show run ..." + Outer.this.num);
		}
	}
	
	public void method(){
		Inner in = new Inner();
		in.show();
	}
}
