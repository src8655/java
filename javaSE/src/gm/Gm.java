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


//화면그리기
class Jp extends JPanel {
	public Games p;	//스레드를 담을 p
	Jp() {
		//게임스레드 시작
		p = new Games(this);
		p.start();
	}
	
	public void paint(Graphics g) {
		//이미지 가져오는 툴
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img;
		
		int posx = 30;
		int posy = 30;
		
		//게임화면 그리기
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
		
		//이전블럭 그리기
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
		
		//게임오버 표시
		if(p.gameover) {
			img = tk.getImage("./images/gameover.png");
			g.drawImage(img, 40+posx, 350+posy, 268, 181, this);
		}
		
		
		
		//점수부분 배경
		g.setColor(Color.BLACK);
		g.fillRect(0+posx, 0+posy, 35*10, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+posx, 44+posy, 35*10, 1);
		

		//점수 가져와서 출력
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
		
		
		//레벨부분 배경
		g.setColor(Color.BLACK);
		g.fillRect(0+370+posx, 0+posy, 35*6, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0+370+posx, 44+posy, 35*6, 1);
		
		img = tk.getImage("./images/level.png");
		g.drawImage(img, 0+370+posx, 5+posy, 35*4, 35, this);
		
		//레벨가져와서 출력
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
		
		
		//키보드 리스너 추가
		frame.addKeyListener( new KeyListener() {
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP: //모양변경
					if(!component.p.start) {
						component.p.moveClear();				//움직이고 있는것 모두 제거
						component.p.nowStyle.change += 1;	//다음모양으로 변경
						component.p.nowStyle.draw();			//다시 그리기
					}
					break;
				case KeyEvent.VK_DOWN:	//아래로
					if(!component.p.start) component.p.down();
					break;
				case KeyEvent.VK_LEFT:	//왼쪽
					if(!component.p.start) component.p.left();
					break;
				case KeyEvent.VK_RIGHT:	//오른쪽
					if(!component.p.start) component.p.right();
					break;
				case KeyEvent.VK_SPACE:	//완전아래로
					//게임오버가 아닐때만 작동
					if(!component.p.gameover) {
						component.p.interrupt();		//자고있는 스레드의 인터럽트 발생
						component.p.now_speed = 0;	//스피드를 제일 빠른 0으로 함
					}
					break;
				case KeyEvent.VK_R:	//재시작
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
