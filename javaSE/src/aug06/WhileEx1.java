package aug06;

public class WhileEx1 {

	public static void main(String[] args) {
		int sum, su;
		sum = su = 0;
		int j= Integer.parseInt(args[0]);
		
		while(su <= j) {
			sum += su;
			su++;
		}
		System.out.println("1~"+j+"까지의 합 : "+sum);
	}

}
