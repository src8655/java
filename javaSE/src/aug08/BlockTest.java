package aug08;

public class BlockTest {
	
	static {
		System.out.println("static { }");
	}
	{
		System.out.println("{ }");
	}
	
	public BlockTest() {
		System.out.println("»ý¼ºÀÚ");
	}

	public static void main(String[] args) {
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();
	}

}
