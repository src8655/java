package aug23;

import java.io.*;

public class ExternalizableEx implements Externalizable {
	private String name;
	private int age;
	private int weight;
	
	public ExternalizableEx() {
		
	}
	public ExternalizableEx(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		name = (String)arg0.readObject();
		age = ((Integer)arg0.readObject()).intValue();
	}
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		arg0.writeObject(name);
		arg0.writeObject(new Integer(age));
	}
	public static void main(String[] args) {
		ExternalizableEx ex1 = new ExternalizableEx("SSOL", 30, 70);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fos = new FileOutputStream("D:\\external.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ex1);
			
			fis = new FileInputStream("D:\\external.ser");
			ois = new ObjectInputStream(fis);
			ExternalizableEx ex2 = (ExternalizableEx)ois.readObject();

			System.out.println("¿øº» °´Ã¼ : "+ex1);
			System.out.println("º¹¿øµÈ °´Ã¼ : "+ex2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
