package aug23.character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InOutStreamReaderEx {
	public static String consoleInput(String input) throws IOException {
		System.out.print(input+" : ");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String message = br.readLine();
		return message;
	}
	public static void main(String[] args) throws IOException {
		String id = consoleInput("id");
		String password = consoleInput("password");
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		out.write("id : "+id+", password : "+password);
		out.close();
	}

}
