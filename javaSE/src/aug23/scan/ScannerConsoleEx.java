package aug23.scan;

import java.util.Scanner;

public class ScannerConsoleEx {

	public static void main(String[] args) {
		System.out.print("�Է� : ");
		Scanner scan = new Scanner(System.in);
		
		String number = scan.next();
		System.out.printf("��ĵ : %s", number);
		scan.close();  
		
		//�׽�Ʈ
	}

}
