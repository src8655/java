package aug17.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetEx2 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1),"2","2","3","3","4","4","4"};
		Set<Object> set = new LinkedHashSet<Object>();
		
		for(int i=0;i<objArr.length;i++)
			set.add(objArr[i]);
		System.out.println(set);
	}

}
