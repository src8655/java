package aug23.scan;

import java.util.Scanner;

public class ScannerConsoleEx {

	public static void main(String[] args) {
		System.out.print("ÀÔ·Â : ");
		Scanner scan = new Scanner(System.in);
		
		String number = scan.next();
		System.out.printf("½ºÄµ : %s", number);
		scan.close();
	}

}
