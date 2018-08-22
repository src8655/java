package aug10;

public class ArrayTest3 {

	String imsi;
	
	public String[] swap(String[] arr) {
		if(arr.length == 0)
			return null;
		
		imsi = arr[0];
		for(int i=0;i<arr.length-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = imsi;
		return arr;
	}
	
	public static void main(String[] args) {
		ArrayTest3 mt3 = new ArrayTest3();
		String [] arr = {"¼±¾Ö","i¢½u"," »ç¶ûÇØ"};
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		arr = mt3.swap(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
	}

}
