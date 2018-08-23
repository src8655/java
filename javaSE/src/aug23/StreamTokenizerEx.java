package aug23;

import java.io.*;

public class StreamTokenizerEx {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		StreamTokenizer st = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("D:\\streamToken.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			pw.println(10000);
			pw.println("¾È³çÇÏ¼¼¿ä");
			pw.println("src8655@naver.com");
			pw.println("i am a boy");
			pw.println("~!@#");
			
			br = new BufferedReader(new FileReader("D:\\streamToken.txt"));
			st = new StreamTokenizer(br);
			
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				switch(st.ttype) {
				case StreamTokenizer.TT_WORD:
					System.out.println("Word => "+st.sval);
					break;
				case StreamTokenizer.TT_NUMBER:
					System.out.println("Number => "+(int)st.nval);
					break;
					default:
						System.out.println("No word, No number => "+(char)st.ttype);
						break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
				bw.close();
				pw.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
