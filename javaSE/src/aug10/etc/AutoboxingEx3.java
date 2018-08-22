package aug10.etc;

public class AutoboxingEx3 {

	public static void main(String[] args) {
		Integer[] var = {new Integer(100), 200, 300};
		
		for(int i : var)
			System.out.println(i);
	}

}
