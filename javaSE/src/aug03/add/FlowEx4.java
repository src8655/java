package aug03.add;

public class FlowEx4 {

	public static void main(String[] args) {
		int score = 88;
		char grade = ' ';
		grade = (score >= 90) ? 'A' : ((score >= 80) ? 'B' : 'C');
		
		System.out.println("����� ������ "+grade+"�Դϴ�.");
	}

}
