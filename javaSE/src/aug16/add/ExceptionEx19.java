package aug16.add;

public class ExceptionEx19 {

	public static void main(String[] args) {
		method1();
	}
	static void method1() {
		try {
			throw new Exception();
			
		}catch(Exception e) {
			System.out.println("metod1�޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}
}
