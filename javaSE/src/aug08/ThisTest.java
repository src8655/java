package aug08;

public class ThisTest {
	public ThisTest() {
		System.out.println("��ü���� : "+this);
	}

	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		System.out.println("��ü���� : "+tt);
	}

}
