package aug09.exercise;

public class Exercise6_20 {
	static int[] shuffle(int[] arr) {
		for(int i=0;i<arr.length*2;i++) {
			int rand1, rand2;
			while(true) {
				rand1 = (int) (Math.random()*arr.length);
				rand2 = (int) (Math.random()*arr.length);
				if(rand1 != rand2) break;
			}
			int temp = arr[rand1];
			arr[rand1] = arr[rand2];
			arr[rand2] = temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

}
