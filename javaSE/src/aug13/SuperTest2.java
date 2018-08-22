package aug13;

public class SuperTest2 {

	public static void main(String[] args) {
		Child3 c = new Child3();
		c.method();
	}

}

class Parent4 {
	int x = 10;
}

class Child3 extends Parent4 {
	int x = 20;
	void method() {
		System.out.println("x="+x);
		System.out.println("this.x="+super.x);
		System.out.println("super.x="+super.x);
	}
}
