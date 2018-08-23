package aug23.character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		FileReader fr = null;
				
		try {
			fr = new FileReader("d:\\fileWriter.txt");
			
			int readChar;
			while((readChar = fr.read()) != -1)
				System.out.print((char)readChar);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			
				try {
					if(fr != null) fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
