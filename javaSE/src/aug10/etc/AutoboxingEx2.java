package aug10.etc;

public class AutoboxingEx2 {

	Integer var;
	public void setInt(int i) {
		var = i;
	}
	public Integer getInt() {
		return var;
	}
	public static void main(String[] args) {
		AutoboxingEx2 a2 = new AutoboxingEx2();
		a2.setInt(10000);
		int res = a2.getInt();
		System.out.println("res :"+res);
	}

}
