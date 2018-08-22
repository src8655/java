package aug06;

public class MultiForEx1 {

	public static void main(String[] args) {
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) System.out.print(j+"*"+i+"="+i*j+"\t");
			System.out.println();
		}
		
		char ch = 65;
		for(int i=0;i<5;i++) {
			for(int j=0;j<4;j++)
				System.out.print(ch++ + "\t");
			System.out.println();
		}
	}

}
