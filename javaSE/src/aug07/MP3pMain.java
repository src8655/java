package aug07;

public class MP3pMain {

	public static void main(String[] args) {
		MP3p m3 = new MP3p();
		
		m3.setColor("RED");
		m3.memoryUp(10240);

		System.out.println(m3.color);
		System.out.println(m3.memory);
	}

}
