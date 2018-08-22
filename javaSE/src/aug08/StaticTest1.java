package aug08;

public class StaticTest1 {
	int a;
	static String s;
	

	public static void main(String[] args) {
		s = "ÀÚ¹ÙÀÇ ²Ş";
		
		StaticTest1 st1 = new StaticTest1();
		
		st1.a = 1000;
		System.out.println("s : "+s);
	}

}
