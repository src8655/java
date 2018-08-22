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
class Jp extends JPanel {
	public Games p;	//�����带 ���� p
	Jp() {
		//���ӽ����� ����
		p = new Games(this);
		p.start();
	}
	
	public void paint(Graphics g) {
		//�̹��� �������� ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img;
		
		int posx = 30;
		int posy = 30;
		
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
					g.fillRect(j*35+370+posx, i*35+45+posy, 35, 35);
				}else { 
					g.fillRect(j*35+370+posx, i*35+45+posy, 35, 35);
					g.drawImage(p.preblk[j][i].img, j*35+370+posx, i*35+45+posy, 35, 35, this);
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
		g.fillRect(0+370+posx, 0+posy, 35*6, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+370+posx, 44+posy, 35*6, 1);
		
		img = tk.getImage("./images/level.png");
		g.drawImage(img, 0+370+posx, 5+posy, 35*4, 35, this);
		
		//���������ͼ� ���
		int cnts = 10;
		int level = p.level;
		for(int i=0;i<2;i++) {
			int num;
			num = level/cnts;
			level = level%cnts;
			img = tk.getImage("./images/Rnum"+num+".png");
			g.drawImage(img, 370+35*4+10+i*30+posx, 5+posy, 30, 35, this);
			
			cnts = cnts/10;
		}
	}
	
}



public class Gm extends JFrame{
	public static Jp component;
	public static Games thread;
	
	public static void main(String[] args) {
		JFrame frame = new Gm();
		frame.setSize(660,1015);
		frame.setTitle("Gm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		component = new Jp();
		frame.add(component);
		frame.setVisible(true);
		
		
		//Ű���� ������ �߰�
		frame.addKeyListener( new KeyListener() {
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
}
