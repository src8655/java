package aug09;

import java.util.StringTokenizer;

public class StringTokenEx2 {

	public static void main(String[] args) {
		System.out.println("split �׽�Ʈ ::::::::::::::::::::");
		String date = "2015/06//26/";
		String[] sp = date.split("/");
		for(int i = 0;i<sp.length;i++) 
			System.out.println("sp["+i+"] : "+sp[i]);
		System.out.println("StringTokenizer �׽�Ʈ ::::::::::::::::::::");
		StringTokenizer st = new StringTokenizer(date, "/");
		int index = 0;
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println("st"+index+" : "+token);
			index++;
		}
	}

}
