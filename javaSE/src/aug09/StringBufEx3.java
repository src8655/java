package aug09;

public class StringBufEx3 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Sun-Ae");
		StringBuffer sb2 = sb1.append(" & KyungJu");
		
		sb2.insert(6,  " & Yun-A");
		String msg = sb1.toString();
		System.out.println("sb1 : "+msg);
	}

}
