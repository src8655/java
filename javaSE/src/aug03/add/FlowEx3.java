package aug03.add;

public class FlowEx3 {

	public static void main(String[] args) {
		int score = Integer.parseInt(args[0]);
		char grade = ' ';
		
		if(score >= 90)
			grade = 'A';
		else if(score >= 80)
			grade = 'B';
		else 
			grade = 'C';
		
		System.out.println("����� ������ "+grade+"�Դϴ�.");
	}

}
