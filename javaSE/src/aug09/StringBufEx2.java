package aug09;

public class StringBufEx2 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Sun-Ae");
		StringBuffer sb2 = sb1.append(" & KyungJu");
		
		String msg = null;
		if(sb1 == sb2)
			msg = "sb1�� sb2�� ����.";
		else
			msg = "sb1�� sb2�� �ٸ���.";
		System.out.println(msg);
		msg = sb1.toString();
		System.out.println("sb1 : "+msg);
		msg = sb2.toString();
		System.out.println("sb2 : "+msg);
	}

}
