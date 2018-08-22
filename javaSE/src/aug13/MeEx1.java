package aug13;

//final class Me1 {
class Me1 {
	int var = 100;
	public void setVar(int var) {
		this.var = var;
	}
}
public class MeEx1 extends Me1{

	public void setVar(int var) {
		this.var = var;
	}
	public static void main(String[] args) {
		MeEx1 me = new MeEx1();
		me.setVar(1000);
	}

}