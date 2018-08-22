package aug13;

class Me {
	//final int var = 100;
	int var = 100;
	public void setVar(int var) {
		this.var = var;
	}
}
public class MeEx extends Me{

	public void setVar(int var) {
		this.var = var;
	}
	public static void main(String[] args) {
		MeEx me = new MeEx();
		me.setVar(1000);
	}

}
