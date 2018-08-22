package aug06.add;

public class FlowEx20 {

	public static void main(String[] args) {
		System.out.println("자, 이제 카운트다운을 시작합니다.");
		for(int i=10; i>=0; i--) {
			for(long j=0;j<3800000000L;j++) ;
			System.out.println(i);
		}
		System.out.println("Game Over");
	}

}
