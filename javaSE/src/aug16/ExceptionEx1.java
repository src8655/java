package aug16;

import static java.lang.System.out;
public class ExceptionEx1 {
	public static void main(String[] args) {
		int[] var = {10, 200, 30};
		for(int i=0;i<=3;i++)
			out.println("var["+i+"] : "+var[i]);
		out.print("프로그램 끝!");
	}
}
