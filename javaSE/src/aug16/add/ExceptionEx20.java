package aug16.add;

public class ExceptionEx20 {

	public static void main(String[] args) {
		try {
			method1();
		}catch(Exception e) {
			System.out.println("main�޼��忡�� ���ܰ� ó���Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}
	static void method1() throws Exception {
		throw new Exception();
	}

}
