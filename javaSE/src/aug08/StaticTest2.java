package aug08;

class StaticTest2_1 {
	String s1 = "static";
	static String s2 = "STATIC";
	
	public static String getString() {
		return s2;
	}
}
public class StaticTest2 {
	public static void main(String[] args) {
		System.out.println("s2 : "+StaticTest2_1.getString());
	}
}
