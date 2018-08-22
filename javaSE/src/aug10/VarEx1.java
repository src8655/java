package aug10;

public class VarEx1 {

	public String format(String pattern, int ... data) {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0,j=0;i<pattern.length();i++) {
			char c = pattern.charAt(i);
			if(c == '%') {
				sb.append(data[j]);
				j++;
			}else
				sb.append(c);
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		VarEx1 v1 = new VarEx1();
		String msg = v1.format("입력된 값 %, %, %",  100, new Integer(5000),10);
		System.out.println(msg);
		
		msg = v1.format("%이 %보다 많은건가?", new Integer(36), new Integer(28));
		System.out.println(msg);
	}

}
