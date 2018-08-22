package aug13;

public class Zerg extends Unit {
	boolean fly;
	public Zerg(String n, boolean b) {
		name= n;
		energe = 100;
		fly = b;
	}
	public void decEnerge() {
		energe -=6;
	}
}
