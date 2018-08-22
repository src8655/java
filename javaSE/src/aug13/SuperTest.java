package aug13;

public class SuperTest {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.method();
	}
}
class Parent3 {
	int x = 10;
}
class Child2 extends Parent3 {
	void method() {
		System.out.println("x="+x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}
