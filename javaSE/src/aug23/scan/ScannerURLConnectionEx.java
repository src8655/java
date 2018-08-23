package aug23.scan;

import java.util.Scanner;
import java.io.IOException;
import java.net.*;

public class ScannerURLConnectionEx {

	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
		try {
			urlCon = new URL("http://lsm8655.cafe24.com/").openConnection();
			scan = new Scanner(urlCon.getInputStream());
			scan.useDelimiter("\\Z");
			String text = scan.next();
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(scan != null) scan.close();
		}
	}

}
