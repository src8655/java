package aug16.add;

public class ExceptionEx1 {

	public static void main(String[] args) {
		try {
			try {}catch(Exception e) {}
		}catch(Exception e) {
			try {} catch(Exception e1) {}
		}
		
		try {
			
		}catch(Exception e) {}
	}

}
