package aug09.exercise;

public class Exercise6_22 {
	static boolean isNumber(String str) {
		if(str == null || str == "") return false;
		boolean result;
		for(int i=0;i<str.length();i++) {
			result = true;
			for(int j=0;j<10;j++)
				if(str.charAt(i) == Integer.toString(j).charAt(0)) result = false;
			if(result) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
	}

}
