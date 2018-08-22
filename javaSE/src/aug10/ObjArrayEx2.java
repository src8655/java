package aug10;

public class ObjArrayEx2 {

	public static void main(String[] args) {
		String[] arr;
		
		if(args.length>0) {
			arr = args;
			
			for(int i=0;i<arr.length;i++) 
				System.out.println("arr["+i+"]:"+arr[i]);
			
		}else
			System.out.println("args의 내용이 없습니다.");
	}

}
