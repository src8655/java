package aug08;

public class OverloadingTest2 {

	public void getLength(int n) {
		String s = String.valueOf(n);
		getLength(s);
	}
	void getLength(float n) {
		String s= String.valueOf(n);
		getLength(s);
	}
	private int getLength(String str) {
		System.out.println("입력한 값의 길이 : "+str.length());
		return 1;
	}
	public static void main(String[] args) {
		OverloadingTest2 ot2 = new OverloadingTest2();
		
		ot2.getLength(1000);
		ot2.getLength(3.14f);
		ot2.getLength("10000");
	}

}
