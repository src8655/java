package aug23.character;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("D:\\fileWriter.txt", true);
			String message = "�ȳ��ϼ��� FileWriter �׽�Ʈ";
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
