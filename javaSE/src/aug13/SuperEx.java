package aug13;

class Parent2 {
	public Parent2(int a) {
		System.out.println("Parent Ŭ����");
	}
}

public class SuperEx extends Parent2{
	public SuperEx() {
		super(1);
		System.out.println("SuperEx Ŭ����");
	}
	public static void main(String[] args) {
		SuperEx se = new SuperEx();
	}

}
