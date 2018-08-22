package aug17.list;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,5);
		
		v.add("혜리");
		v.add("수지");
		v.add("설현");
		
		System.out.println("벡터크기:"+v.size());
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println("벡터크기:"+v.size());
	}

}
