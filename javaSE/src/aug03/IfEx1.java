package aug03;

public class IfEx1 {

	public static void main(String[] args) {
		int su1 = Integer.parseInt(args[0]);
		String str = "50�̸�";
		
		if(su1 >= 50) 
			str = "50�̻�";
		
		System.out.println(str+"�Դϴ�.");
	}

}
