package aug09.exercise;

public class Exercise6_6 {

	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((double)((x1-x)*(x1-x)+(y1-y)*(y1-y)));
	}
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}

}
