package aug06.add;

public class FlowEx19 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(long i=0;i<3800000000L;i++);
		long endTime = System.currentTimeMillis();

		System.out.println("���۽ð� : "+startTime);
		System.out.println("����ð� : "+endTime);
		System.out.println("�ҿ�ð� : "+(endTime - startTime));
	}

}
