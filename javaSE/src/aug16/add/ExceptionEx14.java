package aug16.add;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionEx14 {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("error.log", true);
			ps = new PrintStream(fos);
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		}catch(Exception ae) {
			System.err.println("-------------------");
			System.err.println("���ܹ߻��ð� : "+new Date());
			
			ae.printStackTrace(System.err);
			System.err.println("���ܸ޽��� : "+ae.getMessage());
			System.err.println("-------------------");
		}
		System.out.println(6);
	}

}
