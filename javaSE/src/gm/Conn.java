package gm;

import java.io.IOException;

import org.jsoup.Jsoup;

public class Conn {
	public static String Hparming(String url, String data) {
		String url_base = "http://lsm8655.cafe24.com/tetris/conn.php";
		String doc;
		try {
			doc = Jsoup.connect(url_base+url).data("data",data).post().toString();
			String docstring[] = doc.split("/-/");
			doc = docstring[1];
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
