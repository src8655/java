package aug16;

public class UserExceptionTest {

	public void test1(String[] n) throws UserException {
		System.out.println("Test1");
		if(n.length<1)
			throw new UserException("�ƹ��͵� ���ٳ�");
		else
			throw new UserException("���� ����", 703);
	}
	public static void main(String[] args) {
		UserExceptionTest ut = new UserExceptionTest();
		try {
			ut.test1(args);
		}catch(UserException ue) {
			ue.printStackTrace();
		}
	}

}
