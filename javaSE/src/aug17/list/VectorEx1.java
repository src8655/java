package aug17.list;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2, 5);
		
		System.out.println(":::::::::::::::Vector������::::::::::::::");
		System.out.println("capacity : "+v.capacity());
		System.out.println("size : "+v.size());
		
		v.add("������");
		v.add("���ֿ�");
		v.addElement("����ö");
		

		System.out.println(":::::::::::::::��� �߰���::::::::::::::");
		System.out.println("capacity : "+v.capacity());
		System.out.println("size : "+v.size());
	}

}
