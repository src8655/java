package aug10.exercise;

public class Exercise5_10 {

	public static void main(String[] args) {
		char[] abcCode ={
				'`','~','!','@','#','$','%','^','&','*',
			 '(',')','-','_','+','=','|','[',']','{',
			 '}',';',':',',','.','/'
			};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		String src = "abc123";
		String result = "";
		for(int i=0; i < src.length();i++) {
			char ch = src.charAt(i);
			boolean isNum = false;
			for(int j=0;j<10;j++)
				if(j == ch-'0') isNum = true;
			if(isNum)
				result += numCode[ch-'0'];
			else
				result += abcCode[ch-'a'];
		}
		System.out.println("src:"+src);
		System.out.println("result:"+result);
	}

}
