package aug08;

public class ThisTest {
	public ThisTest() {
		System.out.println("梓端持失 : "+this);
	}

	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		System.out.println("梓端持失 : "+tt);
	}

}
