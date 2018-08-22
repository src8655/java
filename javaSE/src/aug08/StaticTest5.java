package aug08;

public class StaticTest5 {
	
	int a = 100;
	static int b = 200;
	static {
		b = 5000;
		c = 10000;
	}

	public static void main(String[] args) {
		System.out.println(c);
	}
	static int c;

}
