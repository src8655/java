package aug24.socket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MultiClientRoom {
	String id;
	JPanel jpanel;
	Thread t;
	
	
    private JFrame jframe;
    
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    MultiClientRoom(String id) {
    	this.id = id;
    	
    	
        jframe = new JFrame("Multi Chatting Room");
        jframe.setSize(660,600);

        JPanel jp = new JPanel();
        jp.add(new JButton("방 만들기"));

        jframe.add(jp, BorderLayout.SOUTH);
        
        jpanel = new JPanel();
        JScrollPane jsp = new JScrollPane(jpanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jframe.add(jsp, BorderLayout.CENTER);
        

        jframe.setVisible(true);
        
        
    }
    public void init() throws IOException {
        socket = new Socket("localhost", 1234);
        System.out.println("connected...");
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        MultiClientRoomThread ct = new MultiClientRoomThread(this);
        t = new Thread(ct);
        t.start();
        oos.writeObject("-99#"+id+"#room");
    }
	public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MultiClientRoom cc_r = new MultiClientRoom(args[0]);
        cc_r.init();
        /*
        MultiClient cc = new MultiClient("localhost","123",0);
        cc.init();*/
	}
	

	public ObjectInputStream getOis(){
        return ois;
    }
	public ObjectOutputStream getOos(){
        return oos;
    }
    public String getId(){
        return id;
    }
    
    //리스트 그리기
    public void rep(String message) {
    	String[] split = message.split("#");
		jpanel.removeAll();	//패널 클리어
		for(int i=1;i<split.length;i++) {
			JButton btn = new JButton(split[i]+"번 방");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = e.getActionCommand();
					String[] slt = name.split("번");
					int no = Integer.parseInt(slt[0]);
					
			        try {
						MultiClient cc = new MultiClient("localhost",id,no);
						cc.init();
						
						//t.stop();
						jframe.setVisible(false);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			jpanel.add(btn);
		}
		jpanel.updateUI();
        jframe.repaint();
    }

}
