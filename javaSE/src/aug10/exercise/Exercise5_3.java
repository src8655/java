package aug10.exercise;

public class Exercise5_3 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int sum = 0;
		
		for(int i : arr)
			sum += i;
		
		System.out.println("sum="+sum);
	}
}
