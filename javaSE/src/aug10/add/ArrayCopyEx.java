package aug10.add;

public class ArrayCopyEx {

	public static void main(String[] args) {
		byte ar1[] = {11,22,33,44,55};
		byte ar2[] = new byte[10];
		System.arraycopy(ar1, 0, ar2, 3, 5);
		System.out.println("::::::: 원본 배열 :::::::");
		
		for(byte n: ar1)
			System.out.println(n);
		System.out.println("::::::: 복사 배열 :::::::");
		for(byte n:ar2)
			System.out.println(n);
	}

}
