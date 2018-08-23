package aug23.character;

import java.io.*;

public class PrintWriterFirstEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("D:\\printWriterFirst.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			pw.println("æ»≥Á«œººø‰");
			pw.println("π›∞©Ω¿¥œ¥Ÿ.");
			pw.println(100);
			pw.println(new Integer("1000"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fw != null) fw.close();
					if(bw != null) bw.close();
					if(pw != null) pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
