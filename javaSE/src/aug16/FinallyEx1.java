package aug16;

import static java.lang.System.out;
public class FinallyEx1 {

	public static void main(String[] args) {
		int[] var = {10,200,30};
		for(int i=0;i<=3;i++) {
			try {
				out.println((i+1)+"��°");
				out.print("var["+i+"] : "+var[i]);
				out.println("~~~~~~~~~~~");
			}catch(ArrayIndexOutOfBoundsException ae) {
				out.println("�迭�� �Ѿ����ϴ�.");
			}finally {
				out.println("::::: Finally :::::");
			}
		}
		out.println("���α׷� ��!");
	}

}
