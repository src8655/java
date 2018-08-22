package gm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Gm_Multi_List {
	static JFrame frame;
	public static JTextField tf;
	public static JFrame fr;
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setSize(500,100);
		frame.setTitle("Gm_Multi_List");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Button btn0 = new Button("방만들기");
		Button btn1 = new Button("입장하기");

		panel.add(btn0);
		panel.add(btn1);
		
		frame.add(panel);
		frame.setVisible(true);
		
		btn0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String room_num = Conn.Hparming("?order=1","");
				JFrame gm = new Gm_Multi(room_num, true);
				
				frame.dispose();
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr = new JFrame();
				fr.setSize(100,100);
				fr.setTitle("Gm_Multi");
				
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				
				tf = new JTextField();
				Button btn0 = new Button("입장하기");
				panel.add(tf);
				panel.add(btn0);
				
				btn0.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String msg = Conn.Hparming("?order=2&no="+tf.getText(),"");
						
						if(msg.equals("in")) {
							JFrame gm = new Gm_Multi(tf.getText(), false);
							
							fr.dispose();
						}else
							System.out.println("입장 불가능");
					}
				});

				fr.add(panel);
				fr.setVisible(true);
				
				frame.dispose();
			}
		});
	}

}
