package aug10.add;

public class ArrayEx3 {

	public static void main(String[] args) {
		int[] number = new int[10];
		
		for(int i=0;i<10;i++) {
			number[i] = i;
			System.out.print(number[i]);
		}
		System.out.println();
		
		for(int i=0;i<100;i++) {
			int n = (int)(Math.random() * 10);
			
			int temp = number[1];
			number[1] = number[n];
			number[n] = temp;
		}
		for(int i=0;i<number.length;i++)
			System.out.print(number[i]);
	}

}
