package aug23;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {

	public static void main(String[] args) {
		RandomAccessFile ra = null;
		
		try {
			ra = new RandomAccessFile("D:\\random.txt", "rw");
			String receive = "hello";
			ra.seek(ra.length());
			ra.write(receive.getBytes());
			
			byte[] buf = new byte[(int)ra.length()];
			ra.seek(0);
			ra.read(buf);
			System.out.print("처음 읽은 내용 : ");
			System.out.println(new String(buf));
			ra.seek(0);
			ra.read(buf);
			System.out.print("다시 읽은 내용 : ");
			System.out.println(new String(buf));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ra.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
