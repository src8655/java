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
	
	JButton button;
	
	
    private JFrame jframe;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    MultiClientRoom(String id) {
    	this.id = id;
    	
    	
        jframe = new JFrame("Multi Chatting Room");
        jframe.setSize(660,600);

        JPanel jp = new JPanel();
        button = new JButton("�� �����");
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//�游��� ��û
				/*
		        try {
					oos.writeObject("make_room#"+id+"#make_room");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
        jp.add(button);

        jframe.add(jp, BorderLayout.SOUTH);
        
        jpanel = new JPanel();
        JScrollPane jsp = new JScrollPane(jpanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jframe.add(jsp, BorderLayout.CENTER);
        

        jframe.setVisible(true);
        
        
    }
    public void init() throws IOException {
        socket = new Socket("localhost", 5321);
        System.out.println("connected...");
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        MultiClientRoomThread ct = new MultiClientRoomThread(this);
        Thread t = new Thread(ct);
        t.start();
        oos.writeObject("room#"+id+"#room");
    }
	public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MultiClientRoom cc_r = new MultiClientRoom(args[0]);
        cc_r.init();
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
    
    //����Ʈ �׸���
    public void rep(String message) {
    	String[] split = message.split("#");
		jpanel.removeAll();	//�г� Ŭ����
		for(int i=1;i<split.length;i++) {
			JButton btn = new JButton(split[i]+"�� ��");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = e.getActionCommand();
					String[] slt = name.split("��");
					int no = Integer.parseInt(slt[0]);
					
			        try {
						MultiClient cc = new MultiClient("localhost",id,no);
						cc.init();
						
						jframe.setVisible(false);
						
					} catch (IOException e1) {
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
