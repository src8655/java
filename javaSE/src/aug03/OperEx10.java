package aug03;

public class OperEx10 {

	public static void main(String[] args) {
		int a = 14;
		int b = 15;
		String c = "";
		String s = "ũ�� ";
		
		s += ++a >= b ? (a == b?"�� �ƴ϶� ����": (a-b)+"��ŭ a��..") : (b-a)+"��ŭ b��..";
		
		System.out.println(s);
	}

}
