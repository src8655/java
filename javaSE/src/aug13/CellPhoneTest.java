package aug13;

public class CellPhoneTest {

	public static void main(String[] args) {
		D_caPhone dca = new D_caPhone("IN-7600", "011-9XXX-9XXXX", 60, "400¸¸");
		MP3Phone mp = new MP3Phone("KN-600", "011-9XXX-9XXXX", 60, 256);

		System.out.println(dca.getModel()+","+dca.getChord()+","+dca.getNumber());
		System.out.println(mp.getModel()+","+mp.getChord()+","+mp.getNumber());
	}

}
