package aug23.scan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReadableEx {

	public static void main(String[] args) {
		Scanner scan = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader("D:\\scan.txt");
			scan = new Scanner(fr);
			while(scan.hasNext())
				System.out.printf("½ºÄµ : %s %n", scan.next());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fr != null) fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(scan != null) scan.close();
		}
	}

}
