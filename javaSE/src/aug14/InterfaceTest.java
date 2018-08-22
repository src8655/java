package aug14;

class A {
	public void methodA(B b) {
		b.methodB();
	}
}
class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}
public class InterfaceTest {

	public static void main(String[] args) {
		new A().methodA(new B());
	}

}
