package test;

import java.io.*;

public class test3 {

	public static void main(String[] args) {
		test3 tt = new test3();
		tt.fileOpen("D:\\test.txt");
	}
	
	public void fileOpen(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String tmp;
			while((tmp = br.readLine()) != null)
				System.out.println(tmp);
			
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
