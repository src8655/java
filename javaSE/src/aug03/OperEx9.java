package aug03;

public class OperEx9 {

	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		String s = "ũ��";
		
		s += (++a >= b) ? (a-b)+"��ŭ a��.." : (b-a)+"��ŭ b��..";
		
		System.out.println(s);
	}

}
