package aug09;

public class StringEx6 {

	public static void main(String[] args) {
		String s1 = "  aaa  ";
		String msg = null;
		
		msg = s1.replace("aa", "b");
		System.out.println("msg : "+msg);
		
		msg = s1.toUpperCase();
		System.out.println("msg : "+msg);
		msg = s1.trim();
		System.out.println("msg : "+msg);
		msg = String.valueOf(s1.length());
		System.out.println("msg : "+msg);
	}

}
