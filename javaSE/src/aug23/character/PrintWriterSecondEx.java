package aug23.character;

import java.io.*;

public class PrintWriterSecondEx {

	public static void main(String[] args) {
		PrintWriter pw = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("D:\\printWriterSecond.txt");
			bos = new BufferedOutputStream(fos);
			pw = new PrintWriter(bos, true);
			pw.println("¾È³çÇÏ¼¼¿ä");
			pw.println("¶Ç ¸¸³µ³×¿ä.");
			pw.println(100.0);
			pw.println(new Boolean(true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fos != null) fos.close();
					if(bos != null) bos.close();
					if(pw != null) pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
