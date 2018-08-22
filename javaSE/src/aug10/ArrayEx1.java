package aug10;

public class ArrayEx1 {

	public static void main(String[] args) {
		char[] ch = new char[5];
		for(int i=0;i<5;i++) 
			ch[i] = (char)(i+65);
		
		for(int i=0;i<ch.length;i++)
			System.out.println("ch["+i+"]:"+ch[i]);
	}

}
