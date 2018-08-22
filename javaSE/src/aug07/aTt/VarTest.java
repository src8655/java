package aug07.aTt;

public class VarTest {
	public void argTest(String ... n) {
		for(int i=0;i<n.length;i++) {
			System.out.println("n["+i+"]:"+n[i]);
		}
		System.out.println("-----------------------------");
	}
	public static void main(String[] args) {
		VarTest vt = new VarTest();
		vt.argTest("Varargs","Test");
		
		vt.argTest("100","600","900","1000");
		vt.argTest();
	}

}