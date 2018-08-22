package aug03;

public class OperEx9 {

	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		String s = "크다";
		
		s += (++a >= b) ? (a-b)+"만큼 a가.." : (b-a)+"만큼 b가..";
		
		System.out.println(s);
	}

}
