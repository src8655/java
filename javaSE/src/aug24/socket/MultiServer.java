package aug24.socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MultiServer {
	private ArrayList<MultiServerThread> list;
	private ArrayList<Integer> room_list;
	
	private Socket socket;
	public MultiServer() throws IOException {
		list = new ArrayList<MultiServerThread>();
		room_list = new ArrayList<Integer>();
		
		//Å×½ºÆ®
		room_list.add(22);
		room_list.add(23);
		room_list.add(24);
		room_list.add(25);
		room_list.add(26);
		
		ServerSocket serverSocket = new ServerSocket(1234);  
		MultiServerThread mst = null;  
		boolean isStop = false;  
		while(!isStop) {   
			System.out.println("Server ready...");   
			socket = serverSocket.accept();   
			mst = new MultiServerThread(this);   
			list.add(mst);
			Thread t = new Thread(mst);   
			t.start();  
		} 
	}
	public ArrayList<MultiServerThread> getList() {  
		return list; 
	} 
	public ArrayList<Integer> getRoomList() {  
		return room_list; 
	} 
	
	public Socket getSocket() {  
		return socket; 
	}
	public static void main(String[] args) throws IOException {
		new MultiServer(); 
	}
	
}
