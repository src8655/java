package aug13;

public class AbsEx extends AbsEx2 {
	public int getA() {
		return a;
	}
	public String getStr() {
		return str;
	}
	public static void main(String[] args) {
		AbsEx ae = new AbsEx();
		System.out.println("ae.getA();"+ae.getA());
		System.out.println("ae.getStr();"+ae.getStr());
	}

}
