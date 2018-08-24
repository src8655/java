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
                if(no == -99) no = Integer.parseInt(str[0]);		//���ȣ ������ �ޱ�
                if(id == null) id = str[1];		//���̵� ������ �ޱ�
                if(str[2].equals("exit")){
                    broadCasting(message, no);
                    isStop = true;
                }else if(str[2].equals("room")) {
                	//�� ����Ʈ �ް�
                	ArrayList<Integer> room_list = ms.getRoomList();
                	message = "room";	//ù���ڴ� ����
                	for(int i=0;i<room_list.size();i++)
                		message = message+"#"+room_list.get(i).toString();
                	broadCastingOne(message, id);		//�ѻ�����׸� ������
            	/*}else if(str[2].equals("make_room")) {	//�游��� ��û�� ������
                	ms.roomcnt++;						//�� ī��Ʈ �߰�
                	ms.room_list.add(ms.roomcnt);		//�� ����Ʈ�� �߰�
            		
                	message = "make_room#"+id+"#"+ms.roomcnt;	//�������� �� ��ȣ ����
                	broadCastingOne(message, id);	//�ѻ�����׸� ������*/
            	}else{
                    broadCasting(message, no);
                }
            }
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+"���������� �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }catch(Exception e){
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+"������������ �����ϼ̽��ϴ�");
            System.out.println("list size : "+ms.getList().size());
        }
	}
	public void broadCasting(String message, int send_no)throws IOException{
        for(MultiServerThread ct : ms.getList()){
        	if(ct.no == send_no)
        		ct.send(message);	//���� �� ��ȣ �����忡�� ���������� ������
        }
    }
	public void broadCastingOne(String message, String send_id)throws IOException{
        for(MultiServerThread ct : ms.getList()){
        	if(ct.id.equals(send_id))
        		ct.send(message);	//���� �� ��ȣ �����忡�� ���������� ������
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
    }
    
}
