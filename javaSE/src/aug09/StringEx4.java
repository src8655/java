package aug09;

public class StringEx4 {
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
		String s2 = new String("KWON SUN AE");
		String msg = null;
		String msg2 = "";
		
		if(s1.equals(s2))
			msg = "s1�� s2�� ������ ����.";
		else
			msg = "s1�� s2�� ������ �ٸ���.";
		System.out.println(msg);
		
		if(s1.equalsIgnoreCase(s2))
			msg = "s1�� s2�� ��/�ҹ��� �������� ����.";
		else
			msg = "s1�� s2�� ��/�ҹ��� �������̵� �ٸ���.";
		System.out.println(msg);
		
		msg = String.format("%20s, %s",  s1, s2);
		System.out.println("msg : "+msg);
		
	}
}
