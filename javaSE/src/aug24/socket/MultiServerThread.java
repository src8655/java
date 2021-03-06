package aug24.socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MultiServerThread implements Runnable {
	private int no = -99;
	private String id = null;
	
	private Socket socket;
    private MultiServer ms;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public MultiServerThread(MultiServer ms){
        this.ms = ms;
    }

	@Override
	public synchronized void run() {
		boolean isStop = false;
        try{
            socket = ms.getSocket();
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            String message = null;
            while(!isStop){
                message = (String)ois.readObject();
                String[] str = message.split("#");
                if(no == -99 || no == -98 || no == -97) no = Integer.parseInt(str[0]);		//방번호 없으면 받기
                if(id == null) id = str[1];		//아이디 없으면 받기
                if(str[2].equals("exit")){
                    broadCasting(message, no);
                    isStop = true;
                }else if(str[2].equals("room")) {
                	//방 리스트 받고
                	ArrayList<Integer> room_list = ms.getRoomList();
                	message = "-98";	//첫문자는 무시
                	for(int i=0;i<room_list.size();i++)
                		message = message+"#"+room_list.get(i).toString();
                	broadCastingOne(message, id);			//한사람한테만 보내기
            	}else if(str[2].equals("makeroom")) {
            		ms.roomcnt++;
                	ms.room_list.add(ms.roomcnt);
                	message = "-97#"+id+"#"+ms.roomcnt;		//방번호 전송
                	broadCastingOne(message, id);			//한사람한테만 보내기
            	}else{
                    broadCasting(message, no);
                }
            }
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+"정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+"비정상적으로 종료하셨습니다");
            System.out.println("list size : "+ms.getList().size());
        }
	}
	public void broadCasting(String message, int send_no)throws IOException{
        for(MultiServerThread ct : ms.getList()){
        	if(ct.no == send_no)
        		ct.send(message);	//같은 방 번호 스레드에만 선택적으로 보내기
        }
    }
	public void broadCastingOne(String message, String send_id)throws IOException{
        for(MultiServerThread ct : ms.getList()){
        	if(ct.id.equals(send_id))
        		ct.send(message);	//같은 방 번호 스레드에만 선택적으로 보내기
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
    }
    
}
