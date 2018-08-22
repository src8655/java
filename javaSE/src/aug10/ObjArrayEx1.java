package aug10;

public class ObjArrayEx1 {

	public static void main(String[] args) {
		String[] arr;
		arr = new String[3];
		
		arr[0] = "Java ";
		arr[1] = "Array ";
		arr[2] = "Test";
		
		for(int i=0;i<arr.length;i++)
			System.out.println("arr["+i+"]="+arr[i]);
	}

}
