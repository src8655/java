package aug06.add;

public class FlowEx26 {

	public static void main(String[] args) {
		for(int i=0;i<=10000;i++) {
			if(i%2==0)
				continue;
			System.out.println(i);
		}
	}

}
