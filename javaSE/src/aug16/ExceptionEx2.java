package aug16;

import static java.lang.System.out;

public class ExceptionEx2 {

	public static void main(String[] args) {
		int[] var = {10, 200, 30};
		for(int i=0;i<=3;i++)
			try {
			out.println("var["+i+"] : "+var[i]);
			}catch(ArrayIndexOutOfBoundsException ae){
				out.print("�迭�� �Ѿ����ϴ�.");
			}
		out.print("���α׷� ��!");
	}

}
