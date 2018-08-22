package aug06.add;

public class FlowEx19 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(long i=0;i<3800000000L;i++);
		long endTime = System.currentTimeMillis();

		System.out.println("시작시간 : "+startTime);
		System.out.println("종료시간 : "+endTime);
		System.out.println("소요시간 : "+(endTime - startTime));
	}

}
