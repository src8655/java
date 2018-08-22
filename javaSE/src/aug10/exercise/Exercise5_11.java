package aug10.exercise;

public class Exercise5_11 {

	public static void main(String[] args) {
		int[][] score = {
				 {100, 100, 100}
				, {20, 20, 20}
				, {30, 30, 30}
				, {40, 40, 40}
				, {50, 50, 50}
		};
		int[][] result = new int[score.length+1][score[0].length+1];
		for(int i=0; i < score.length;i++) {
			for(int j=0; j < score[i].length;j++) {
				result[i][j] = score[i][j];
				result[i][score[0].length] += score[i][j];
				result[score.length][j] += score[i][j];
				result[score.length][score[0].length] += score[i][j];
			}
		}
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}
	}

}
