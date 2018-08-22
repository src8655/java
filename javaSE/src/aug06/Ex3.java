package aug06;

public class Ex3 {

	public static void main(String[] args) {
		int k=0;
		for(int i=1;i<5;i++) {
			for(int j=1;j<=i;j++) {
				k+=j;
				System.out.print(k+"\t");
			}
			System.out.println();
		}
	}

}
