package gm;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

//ȭ��׸���
class Jp_Multi extends JPanel {
	public Games p;	//�����带 ���� p
	Jp_Multi() {
		//���ӽ����� ����
		p = new Games(this);
		p.start();
	}
	
	public void paint(Graphics g) {
		//�̹��� �������� ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img;
		
		int posx = 0;
		int posy = 0;
		
		//����ȭ�� �׸���
		for(int i=2;i<Games.HEIGHTS;i++) {
			for(int j=0;j<Games.WIDTHS;j++) {
				if(p.blk[j][i] == null) {
					g.setColor(Color.BLACK);
					g.fillRect(j*35+posx, (i-2)*35+45+posy, 35, 35);
					g.setColor(Color.DARK_GRAY);
					g.fillRect(j*35+posx-1, (i-2)*35+45+posy-1, 1, 1);
				}else { 
					//g.setColor(p.blk[j][i].color);
					g.fillRect(j*35+posx, (i-2)*35+45+posy, 35, 35);
					g.drawImage(p.blk[j][i].img, j*35+posx, (i-2)*35+45+posy, 35, 35, this);
				}
			}
		}
		
		//������ �׸���
		for(int i=0;i<p.preblk[0].length;i++) {
			for(int j=0;j<p.preblk.length;j++) {
				if(p.preblk[j][i] == null) {
					g.setColor(Color.BLACK);
					g.fillRect(j*35+360+posx, i*35+45+posy, 35, 35);
				}else { 
					g.fillRect(j*35+360+posx, i*35+45+posy, 35, 35);
					g.drawImage(p.preblk[j][i].img, j*35+360+posx, i*35+45+posy, 35, 35, this);
				}
			}
		}
		
		//���ӿ��� ǥ��
		if(p.gameover) {
			img = tk.getImage("./images/gameover.png");
			g.drawImage(img, 40+posx, 350+posy, 268, 181, this);
		}
		
		
		
		//�����κ� ���
		g.setColor(Color.BLACK);
		g.fillRect(0+posx, 0+posy, 35*10, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+posx, 44+posy, 35*10, 1);
		

		//���� �����ͼ� ���
		long cnt = 1000000000L;
		long point = p.gamePoint;
		for(int i=0;i<10;i++) {
			long num;
			num = point/cnt;
			point = point%cnt;
			img = tk.getImage("./images/num"+num+".png");
			g.drawImage(img, i*35+posx, 5+posy, 35, 35, this);
			
			cnt = cnt/10;
		}
		
		
		//�����κ� ���
		g.setColor(Color.BLACK);
		g.fillRect(0+360+posx, 0+posy, 35*6, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+360+posx, 44+posy, 35*6, 1);
		
		img = tk.getImage("./images/level.png");
		g.drawImage(img, 0+360+posx, 5+posy, 35*4, 35, this);
		
		//���������ͼ� ���
		int cnts = 10;
		int level = p.level;
		for(int i=0;i<2;i++) {
			int num;
			num = level/cnts;
			level = level%cnts;
			img = tk.getImage("./images/Rnum"+num+".png");
			g.drawImage(img, 360+35*4+10+i*30+posx, 5+posy, 30, 35, this);
			
			cnts = cnts/10;
		}
		
		
		
		
		
		posx = 580;
		posy = 0;
		
		//����ȭ�� �׸���2
		for(int i=2;i<Games.HEIGHTS;i++) {
			for(int j=0;j<Games.WIDTHS;j++) {
				if(Gm_Multi.blk_multi[j][i] == null) {
					g.setColor(Color.BLACK);
					g.fillRect(j*35+posx, (i-2)*35+45+posy, 35, 35);
					g.setColor(Color.DARK_GRAY);
					g.fillRect(j*35+posx-1, (i-2)*35+45+posy-1, 1, 1);
				}else { 
					//g.setColor(p.blk[j][i].color);
					g.fillRect(j*35+posx, (i-2)*35+45+posy, 35, 35);
					g.drawImage(Gm_Multi.blk_multi[j][i].img, j*35+posx, (i-2)*35+45+posy, 35, 35, this);
				}
			}
		}
		
		//�����κ� ���
		g.setColor(Color.BLACK);
		g.fillRect(0+posx, 0+posy, 35*10, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+posx, 44+posy, 35*10, 1);
				

		//���� �����ͼ� ���
		cnt = 1000000000L;
		point = Gm_Multi.gamePoint_multi;
		for(int i=0;i<10;i++) {
			long num;
			num = point/cnt;
			point = point%cnt;
			img = tk.getImage("./images/num"+num+".png");
			g.drawImage(img, i*35+posx, 5+posy, 35, 35, this);
			
			cnt = cnt/10;
		}
				
	}
	
}
class Waiting extends Thread {

	@Override
	public void run() {
		while(true) {
			String msg = Conn.Hparming("?order=3&no="+Gm_Multi.room_num,"");
			if(msg.equals("start")) {
				Gm_Multi.component.p.interrupt();
				Gm_Multi.component.p.replay();
				Gm_Multi.ug = new UpGame();
				Gm_Multi.ug.start();
				break;
				//Gm_Multi.component.p.replay();
			}else {
				Gm_Multi.component.p.SPEEDS = 999999999;
				Gm_Multi.component.p.now_speed = 999999999;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class UpGame extends Thread {
	@Override
	public void run() {
		while(true) {
			String data = "";
			
			for(int i=0;i<Games.WIDTHS;i++) {
				for(int j=0;j<Games.HEIGHTS;j++) {
					if(Gm_Multi.component.p.blk[i][j] == null) {
						data += "null/=";
					}else {
						data += Gm_Multi.component.p.blk[i][j].url+"/=";
					}
				}
			}
			data += Gm_Multi.component.p.gamePoint+"/=";
			
			String msg = Conn.Hparming("?order=4&no="+Gm_Multi.room_num+"&host="+Boolean.toString(Gm_Multi.isHost),data);
			if(msg.equals("in"))
				;
			else {
				String[] temp = msg.split("/=");
				
				int cnt = 0;
				for(int i=0;i<Games.WIDTHS;i++) {
					for(int j=0;j<Games.HEIGHTS;j++) {
						if(temp[cnt].equals("null")) {
							Gm_Multi.blk_multi[i][j] = null;
						}else {
							Gm_Multi.blk_multi[i][j] = new Block(temp[cnt]);
						}
						cnt++;
					}
				}
				Gm_Multi.gamePoint_multi = Long.parseLong(temp[cnt]);
			}
			Gm_Multi.component.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Gm_Multi extends JFrame{
	public static UpGame ug;
	public static Block[][] blk_multi = new Block[Games.WIDTHS][Games.HEIGHTS];	//�� ĭ
	public static long gamePoint_multi = 0L;
	public static Jp_Multi component;
	public static String room_num;	//���ȣ
	public static boolean isHost;	//true�� ȣ��Ʈ false�� �մ�
	
	Gm_Multi(String room_num, boolean isHost) {
		this.room_num = room_num;
		this.isHost = isHost;
		
		this.setSize(946,959);
		this.setTitle(room_num+"�� ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		component = new Jp_Multi();
		this.add(component);
		this.setVisible(true);
		
		Waiting w = new Waiting();
		w.start();
		
		
		this.addKeyListener( new KeyListener() {
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP: //��纯��
					if(!component.p.start) {
						component.p.moveClear();				//�����̰� �ִ°� ��� ����
						component.p.nowStyle.change += 1;	//����������� ����
						component.p.nowStyle.draw();			//�ٽ� �׸���
					}
					break;
				case KeyEvent.VK_DOWN:	//�Ʒ���
					if(!component.p.start) component.p.down();
					break;
				case KeyEvent.VK_LEFT:	//����
					if(!component.p.start) component.p.left();
					break;
				case KeyEvent.VK_RIGHT:	//������
					if(!component.p.start) component.p.right();
					break;
				case KeyEvent.VK_SPACE:	//�����Ʒ���
					//���ӿ����� �ƴҶ��� �۵�
					if(!component.p.gameover) {
						component.p.interrupt();		//�ڰ��ִ� �������� ���ͷ�Ʈ �߻�
						component.p.now_speed = 0;	//���ǵ带 ���� ���� 0���� ��
					}
					break;
				case KeyEvent.VK_R:	//�����
					component.p.replay();
					break;
				default:
					break;
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
	}
	
	public static void main(String[] args) {
	
		
	}
}
