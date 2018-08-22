package aug09;

public class StringEx1 {

	public static void main(String[] args) {
		String s1 = "Twinkle";
		String s2 = "Twinkle";
		
		if(s1 == s2)
			System.out.println("s1과 s2는 같다. ");
		else
			System.out.println("s1과 s2는 같지 않다. ");

		String s3 = new String("Little Star");
		String s4 = new String("Little Star");
		
		if(s3 == s4)
			System.out.println("s3과 s4는 같다. ");
		else
			System.out.println("s3과 s4는 같지 않다. ");
		
	}

}
