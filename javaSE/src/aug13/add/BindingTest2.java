package aug13.add;

public class BindingTest2 {

	public static void main(String[] args) {
		Parent6 p = new Child6();
		Child6 c = new Child6();

		System.out.println("p.x = "+p.x);
		p.method();
		System.out.println("c.x = "+c.x);
		c.method();
	}

}
class Parent6 {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}
class Child6 extends Parent6 {}
