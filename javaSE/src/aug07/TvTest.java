package aug07;

class Tv1 {
	String color;
	boolean power;
	int channel;
	
	void power() { power = !power;}
	void channelUp() {++channel;}
	void channelDown() { --channel;}
}

public class TvTest {

	public static void main(String[] args) {
		Tv1 t;
		t = new Tv1();
		t.channel = 7;
		t.channelDown();
		System.out.println("���� ä���� "+t.channel+" �Դϴ�.");
	}

}