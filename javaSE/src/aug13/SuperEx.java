package aug13;

class Parent2 {
	public Parent2(int a) {
		System.out.println("Parent 클래스");
	}
}

public class SuperEx extends Parent2{
	public SuperEx() {
		super(1);
		System.out.println("SuperEx 클래스");
	}
	public static void main(String[] args) {
		SuperEx se = new SuperEx();
	}

}
