package aug16;

import static java.lang.System.out;
public class ExceptionEx3 {

	public static void main(String[] args) {
		int var = 50;
		try {
			int data = Integer.parseInt(args[0]);
			out.println(var/data);
		}catch(NumberFormatException ne) {
			out.println("���ڰ� �ƴմϴ�.");
		}catch(ArithmeticException ae) {
			out.print("0���� ������ ����?");
		}catch(ArrayIndexOutOfBoundsException ae) {
			out.println("�迭�� �Ѿ����ϴ�.");
		}
		out.println("���α׷� ����!");
	}

}
