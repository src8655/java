package aug13;

class Card4 {
	final int NUMBER;
	final String KIND;
	static int width = 100;
	static int height = 250;
	
	Card4(String kind, int num) {
		KIND = kind;
		NUMBER = num;
	}
	Card4() {
		this("HEART", 1);
	}
	public String toString() {
		return ""+KIND+" "+NUMBER;
	}
}
public class FinalCardTest {

	public static void main(String[] args) {
		Card4 c = new Card4("HEART", 10);
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
	}

}
