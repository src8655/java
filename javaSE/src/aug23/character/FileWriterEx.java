package aug23.character;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("D:\\fileWriter.txt", true);
			String message = "안녕하세요 FileWriter 테스트";
			fw.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if(fw != null)fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
