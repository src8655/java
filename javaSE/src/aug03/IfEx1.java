package aug03;

public class IfEx1 {

	public static void main(String[] args) {
		int su1 = Integer.parseInt(args[0]);
		String str = "50미만";
		
		if(su1 >= 50) 
			str = "50이상";
		
		System.out.println(str+"입니다.");
	}

}
