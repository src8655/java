package aug09.add;

public class StringReplace {
	
	private String source = "";
	private int length;
	private StringBuffer buffer;
	
	public StringReplace(String source) {
		this.source = source;
		length = source.length();
		buffer = new StringBuffer(length + 100);
	}
	public int length() {
		return length;
	}
	public String replace(String old, String nw) {
		return replace(old, nw, 0);
	}
	public String replace(String old, String nw, int pos) {
		int index = 0;
		if(old == null || nw == null)
			return "null";
		if((index = source.indexOf(old, pos))!= -1) {
			buffer.append(source.substring(pos, index));
			buffer.append(nw);
			
			replace(old, nw, index + old.length());
		}else 
			buffer.append(source.substring(pos));
		return buffer.toString();
	}

	public static void main(String[] args) {
		String str = "000111222333111222333";
		System.out.println(str);
		StringReplace sc = new StringReplace(str);
		System.out.println(sc.replace("111", "AAA"));
	}

}
