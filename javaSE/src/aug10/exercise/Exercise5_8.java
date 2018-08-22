package aug10.exercise;

public class Exercise5_8 {

	public static void main(String[] args) {
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];
		
		for(int i=0;i<answer.length;i++) {
			for(int j=0;j<counter.length;j++)
				if(answer[i] == j+1)counter[answer[i]-1]++;
		}
		for(int i=0;i<counter.length;i++) {
			System.out.print(counter[i]);
			for(int j=0;j<counter[i];j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
