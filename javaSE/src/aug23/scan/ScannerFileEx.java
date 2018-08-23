package aug23.scan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileEx {

	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("D:\\scan.txt"));
			while(scan.hasNext())
				System.out.printf("½ºÄµ : %s %n", scan.next());
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
