package aug16.add;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			Exception e = new Exception("���Ƿ� �߻�������.");
			throw e;
			
		}catch(Exception e) {
			System.out.println("���� �޽��� : "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("���α׷��� ���� ����Ǿ���.");
	}

}
