package aug24.socket;

import java.io.IOException;

import javax.swing.JButton;

public class MultiClientRoomThread extends Thread{
    private MultiClientRoom mcr;
    public MultiClientRoomThread(MultiClientRoom mcr){
        this.mcr = mcr;
    }
    public void run(){
        String message = null;
        String[] receivedMsg = null;
        boolean isStop = false;
        while(!isStop){
        	
        	
            try{
                message = (String)mcr.getOis().readObject();
                receivedMsg = message.split("#");
            }catch(Exception e){
                e.printStackTrace();
                isStop = true;
            }
            System.out.println(message);

            //재요청
            try {
            	if(receivedMsg.length > 0)
				if(receivedMsg[0].equals("-98")) mcr.rep(message);
				mcr.getOos().writeObject("-99#"+mcr.id+"#room");
				

				if(receivedMsg[0].equals("-97")) {
					mcr.inroom(mcr.id,receivedMsg[2]);
				}
				
				Thread.sleep(1000);//1초 대기
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
        }
    }
}