package aug06.add;

public class FlowEx20 {

	public static void main(String[] args) {
		System.out.println("��, ���� ī��Ʈ�ٿ��� �����մϴ�.");
		for(int i=10; i>=0; i--) {
			for(long j=0;j<3800000000L;j++) ;
			System.out.println(i);
		}
		System.out.println("Game Over");
	}

}
