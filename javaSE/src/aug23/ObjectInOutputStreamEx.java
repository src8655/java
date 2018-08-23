package aug23;

import java.io.*;

public class ObjectInOutputStreamEx {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("D:\\object.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Customer("SSOL"));
			
			fis = new FileInputStream("D:\\object.ser");
			ois = new ObjectInputStream(fis);
			Customer m = (Customer)ois.readObject();
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(fis != null) fis.close();
					if(ois != null) ois.close();
					if(fos != null) fos.close();
					if(oos != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
