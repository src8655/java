package aug03;

public class IfEx4 {

	public static void main(String[] args) {
		String data = args[0];
		
		String res;
		if(data == "포도")
			res = "달다.";
		else if(data.equals("수박"))
			res = "시원하다.";
		else if(data.equals("딸기"))
			res = "맛있다.";
		else
			res = "기타";
		
		System.out.println(res);
	}

}
