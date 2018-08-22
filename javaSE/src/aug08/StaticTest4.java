package aug08;

public class StaticTest4 {
	static {
		System.out.println("Static init1");
	}
	static String s = echo("string");
	static {
		System.out.println("Static init2");
	}
	static String echo(String s) {
		System.out.println(s);
		return s;
	}
	public static void main(String[] args) {
		System.out.println("main");
		StaticTest4 staticTest4 = new StaticTest4();
	}

}
