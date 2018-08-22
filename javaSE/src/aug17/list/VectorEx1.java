package aug17.list;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2, 5);
		
		System.out.println(":::::::::::::::Vector생성시::::::::::::::");
		System.out.println("capacity : "+v.capacity());
		System.out.println("size : "+v.size());
		
		v.add("박지성");
		v.add("박주영");
		v.addElement("유상철");
		

		System.out.println(":::::::::::::::요소 추가후::::::::::::::");
		System.out.println("capacity : "+v.capacity());
		System.out.println("size : "+v.size());
	}

}
