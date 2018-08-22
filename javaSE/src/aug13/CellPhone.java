package aug13;

public class CellPhone {
	String model;
	String number;
	int chord;
	
	protected void stNumber(String n) {
		number = n;
	}
	public String getModel() {
		return model;
		
	}
	public int getChord() {
		return chord;
	}
	public String getNumber() {
		return number;
	}
}
