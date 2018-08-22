package aug07;

public class MethodEx {
	int var1, var2;
	public int sum(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
			MethodEx me = new MethodEx();
			int res = me.sum(1000,  -10);
			System.out.println("res="+res);
	}

}
