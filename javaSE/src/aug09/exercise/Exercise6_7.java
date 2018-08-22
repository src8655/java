package aug09.exercise;

class MyPoint {
	int x;
	int y;
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	double getDistance(int x1, int y1) {
		return Math.sqrt((double)((x1-x)*(x1-x)+(y1-y)*(y1-y)));
	}
}
public class Exercise6_7 {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		System.out.println(p.getDistance(2, 2));
	}

}
