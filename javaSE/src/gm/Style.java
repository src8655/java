package gm;

import javax.swing.JPanel;

class Style {
	JPanel jpanel;
	Games p;	//�����带 ���� p
	boolean isfirst = true;	//ù��° ���� ������
	int rand;
	int change = 0;
	String img;
	Style(Games p, JPanel jpanel) {
		this.p = p;
		this.jpanel = jpanel;
		
		//�� ���� 0~5
		rand = (int)(Math.random()*6);
		//���� ����
		switch(rand) {
		case 0: img = "./images/block0.png"; break;
		case 1: img = "./images/block1.png"; break;
		case 2: img = "./images/block2.png"; break;
		case 3: img = "./images/block3.png"; break;
		case 4: img = "./images/block4.png"; break;
		case 5: img = "./images/block5.png"; break;
		default: break;
		}
		
		//�� ��� ���� 0~6
		rand = (int)(Math.random()*7);
	}
	
	//����ȭ�鿡 �׸���
	void draw() {
		switch(rand) {
		//��
		case 0:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx][p.posy+1] != null
						|| p.blk[p.posx+1][p.posy+1] != null) {
					change--;
					if(!isfirst) draw();	//ù��° ���ε� ���������� �ȱ׸�����
					else p.gameOver();		//���ӿ���
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				p.blk[p.posx+1][p.posy+1] = new Block(img);
				isfirst = false;
				break;
			case 1:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx-1][p.posy+1] != null 
						|| p.blk[p.posx-1][p.posy] != null
						|| p.blk[p.posx+1][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx-1][p.posy+1] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				break;
			case 2:
				if(		p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx-1][p.posy-1] != null 
						|| p.blk[p.posx][p.posy-1] != null
						|| p.blk[p.posx][p.posy+1] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx-1][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				break;
			case 3:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.blk[p.posx+1][p.posy-1] != null 
						|| p.blk[p.posx+1][p.posy] != null
						|| p.blk[p.posx-1][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx+1][p.posy-1] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				break;
			default:
				break;
			}
			break;
		
		//��
		case 1:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx][p.posy+1] != null
						|| p.blk[p.posx-1][p.posy+1] != null) {
					change--;
					if(!isfirst)draw();
					else p.gameOver();
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				p.blk[p.posx-1][p.posy+1] = new Block(img);
				isfirst = false;
				break;
			case 1:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.blk[p.posx-1][p.posy-1] != null 
						|| p.blk[p.posx-1][p.posy] != null
						|| p.blk[p.posx+1][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx-1][p.posy-1] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				break;
			case 2:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx+1][p.posy-1] != null 
						|| p.blk[p.posx][p.posy-1] != null
						|| p.blk[p.posx][p.posy+1] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx+1][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				break;
			case 3:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx+1][p.posy+1] != null 
						|| p.blk[p.posx+1][p.posy] != null
						|| p.blk[p.posx-1][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx+1][p.posy+1] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				break;
			default:
				break;
			}
			break;
			
			
		//��
		case 2:
			if(		p.posy+1 >= Games.HEIGHTS
					|| p.posx+1 >= Games.WIDTHS
					|| p.blk[p.posx+1][p.posy] != null 
					|| p.blk[p.posx][p.posy+1] != null
					|| p.blk[p.posx+1][p.posy+1] != null) {
				change--;
				if(!isfirst) draw();
				else p.gameOver();
				break;
			}
			p.blk[p.posx][p.posy] = new Block(img);
			p.blk[p.posx+1][p.posy] = new Block(img);
			p.blk[p.posx][p.posy+1] = new Block(img);
			p.blk[p.posx+1][p.posy+1] = new Block(img);
			isfirst = false;
			break;
		//��
		case 3:
			if(change > 1) change = 0;
			if(change < 0) change = 1;
			switch(change) {
			case 0:
				if(		p.posy+1 >= Games.HEIGHTS
						|| p.posy+2 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx][p.posy+1] != null
						|| p.blk[p.posx][p.posy+2] != null) {
					change--;
					if(!isfirst)draw();
					else p.gameOver();
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				p.blk[p.posx][p.posy+2] = new Block(img);
				isfirst = false;
				break;
			case 1:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx+2 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.blk[p.posx-1][p.posy] != null 
						|| p.blk[p.posx+1][p.posy] != null
						|| p.blk[p.posx+2][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				p.blk[p.posx+2][p.posy] = new Block(img);
				break;
			default:
				break;
			}
			break;
			
			
		//��
		case 4:
			if(change > 3) change = 0;
			if(change < 0) change = 3;
			switch(change) {
			case 0:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx-1][p.posy] != null
						|| p.blk[p.posx+1][p.posy] != null) {
					change--;
					if(!isfirst) draw();
					else p.gameOver();
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				isfirst = false;
				break;
			case 1:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx+1][p.posy] != null
						|| p.blk[p.posx][p.posy+1] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				break;
			case 2:
				if(		p.posx+1 >= Games.WIDTHS
						|| p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy+1] != null 
						|| p.blk[p.posx-1][p.posy] != null
						|| p.blk[p.posx+1][p.posy] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx][p.posy+1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx+1][p.posy] = new Block(img);
				break;
			case 3:
				if(		p.posx-1 < 0
						|| p.posy+1 >= Games.HEIGHTS
						|| p.blk[p.posx][p.posy-1] != null 
						|| p.blk[p.posx-1][p.posy] != null
						|| p.blk[p.posx][p.posy+1] != null) {
					change--;
					draw();
					break;
				}
				p.blk[p.posx][p.posy-1] = new Block(img);
				p.blk[p.posx][p.posy] = new Block(img);
				p.blk[p.posx-1][p.posy] = new Block(img);
				p.blk[p.posx][p.posy+1] = new Block(img);
				break;
			default:
				break;
			}
			break;
			
			//-_
			case 5:
				if(change > 1) change = 0;
				if(change < 0) change = 1;
				switch(change) {
				case 0:
					if(		p.posy+1 >= Games.HEIGHTS
							|| p.posx-1 < 0
							|| p.posx+1 >= Games.WIDTHS
							|| p.blk[p.posx-1][p.posy] != null 
							|| p.blk[p.posx][p.posy+1] != null
							|| p.blk[p.posx+1][p.posy+1] != null) {
						change--;
						if(!isfirst) draw();
						else p.gameOver();
						break;
					}
					p.blk[p.posx-1][p.posy] = new Block(img);
					p.blk[p.posx][p.posy] = new Block(img);
					p.blk[p.posx][p.posy+1] = new Block(img);
					p.blk[p.posx+1][p.posy+1] = new Block(img);
					isfirst = false;
					break;
				case 1:
					if(		p.posy+1 >= Games.HEIGHTS
							|| p.posx-1 < 0
							|| p.blk[p.posx][p.posy-1] != null 
							|| p.blk[p.posx-1][p.posy] != null
							|| p.blk[p.posx-1][p.posy+1] != null) {
						change--;
						draw();
						break;
					}
					p.blk[p.posx][p.posy-1] = new Block(img);
					p.blk[p.posx][p.posy] = new Block(img);
					p.blk[p.posx-1][p.posy] = new Block(img);
					p.blk[p.posx-1][p.posy+1] = new Block(img);
					break;
				default:
					break;
				}
				break;	
			//_-
			case 6:
				if(change > 1) change = 0;
				if(change < 0) change = 1;
				switch(change) {
				case 0:
					if(		p.posy+1 >= Games.HEIGHTS
							|| p.posx-1 < 0
							|| p.posx+1 >= Games.WIDTHS
							|| p.blk[p.posx+1][p.posy] != null 
							|| p.blk[p.posx][p.posy+1] != null
							|| p.blk[p.posx-1][p.posy+1] != null) {
						change--;
						if(!isfirst) draw();
						else p.gameOver();
						break;
					}
					p.blk[p.posx+1][p.posy] = new Block(img);
					p.blk[p.posx][p.posy] = new Block(img);
					p.blk[p.posx][p.posy+1] = new Block(img);
					p.blk[p.posx-1][p.posy+1] = new Block(img);
					isfirst = false;
					break;
				case 1:
					if(		p.posy+1 >= Games.HEIGHTS
							|| p.posx+1 >= Games.WIDTHS
							|| p.blk[p.posx][p.posy-1] != null 
							|| p.blk[p.posx+1][p.posy] != null
							|| p.blk[p.posx+1][p.posy+1] != null) {
						change--;
						draw();
						break;
					}
					p.blk[p.posx][p.posy-1] = new Block(img);
					p.blk[p.posx][p.posy] = new Block(img);
					p.blk[p.posx+1][p.posy] = new Block(img);
					p.blk[p.posx+1][p.posy+1] = new Block(img);
					break;
				default:
					break;
				}
				break;

			
			
		default:
			break;
		}
		
		
		
		

		jpanel.repaint();
	}
	
	//������ �׸���
	void predraw() {
		
		//������ ����
		for(int i=0;i<p.preblk[0].length;i++)
			for(int j=0;j<p.preblk.length;j++)
				p.preblk[j][i] = null;
		
		switch(rand) {
		//��
		case 0:
			p.preblk[2][2-1] = new Block(img);
			p.preblk[2][2] = new Block(img);
			p.preblk[2][2+1] = new Block(img);
			p.preblk[2+1][2+1] = new Block(img);
			break;
		//��
		case 1:
			p.preblk[3][2-1] = new Block(img);
			p.preblk[3][2] = new Block(img);
			p.preblk[3][2+1] = new Block(img);
			p.preblk[3-1][2+1] = new Block(img);
			break;
		//��
		case 2:
			p.preblk[2][2] = new Block(img);
			p.preblk[2+1][2] = new Block(img);
			p.preblk[2][2+1] = new Block(img);
			p.preblk[2+1][2+1] = new Block(img);
			break;
		//��
		case 3:
			p.preblk[2][2-1] = new Block(img);
			p.preblk[2][2] = new Block(img);
			p.preblk[2][2+1] = new Block(img);
			p.preblk[2][2+2] = new Block(img);
			break;
		//��
		case 4:
			p.preblk[2][3-1] = new Block(img);
			p.preblk[2][3] = new Block(img);
			p.preblk[2-1][3] = new Block(img);
			p.preblk[2+1][3] = new Block(img);
			break;
		//-_
		case 5:
			p.preblk[2-1][2] = new Block(img);
			p.preblk[2][2] = new Block(img);
			p.preblk[2][2+1] = new Block(img);
			p.preblk[2+1][2+1] = new Block(img);
			break;	
		//_-
		case 6:
			p.preblk[2+1][2] = new Block(img);
			p.preblk[2][2] = new Block(img);
			p.preblk[2][2+1] = new Block(img);
			p.preblk[2-1][2+1] = new Block(img);
			break;
		default:
			break;
		}
		jpanel.repaint();
	}
}
