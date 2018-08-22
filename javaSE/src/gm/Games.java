package gm;

import java.util.ArrayList;
import javax.swing.JPanel;

class Games extends Thread {
	final static int WIDTHS = 10;		//ȭ��ʺ�
	final static int HEIGHTS = 27;		//ȭ�����
	public Block[][] blk = new Block[WIDTHS][HEIGHTS];	//�� ĭ
	public Block[][] preblk = new Block[6][6];			//���� �� ĭ
	public boolean start = true;		//����
	public int posx = 4;				//�� ��ġ x
	public int posy = 1;				//�� ��ġy
	public int SPEEDS = 1000;			//���ǵ�
	public int now_speed = 1000;		//���� ���ǵ�
	public boolean gameover = false;	//���ӿ��� �÷���
	public int level = 1;				//����
	public long gamePoint = 0;			//����
	public int linecount = 0;			//������ ���� ī��Ʈ(20�ٸ��� ���� ����)
	public Style preStyle;				//���� �� ���
	public Style nowStyle;				//���� �� ���
	public JPanel jpanel;
	
	Games(JPanel jpanel) {
		this.jpanel = jpanel;
		preStyle = new Style(this, this.jpanel);
	}
	@Override
	public void run() {
		while(true) {
			//���ӿ��� �÷��װ� false�϶��� �۵�
			if(!gameover) {
				if(start) {
					allStop();					//��� �� ���������
					findLine();					//���η� ä���� ������ ã��
					posx = 4;					//ù ��ġ��
					posy = 1;
					start = false;				//�����÷��׸� false
					nowStyle = preStyle;		//���� ��������� �ٲ�
					preStyle = new Style(this, jpanel);	//���� ������� ����
					nowStyle.draw();			//����� ����� �׸���
					preStyle.predraw();			//������ ����� �׸���
					now_speed = SPEEDS;			//���ǵ带 ���� ���ǵ�� ����
				}
				down();	//��ĭ�� �����´�
			}
			show();	//�ֿܼ� ���
			try {
				Thread.sleep(now_speed);// ���� ���ǵ常ŭ ������ ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	//�ٽý���
	public void replay() {
		//���� �ʱ�ȭ
		for(int i=0;i<HEIGHTS;i++)
			for(int j=0;j<WIDTHS;j++)
				blk[j][i] = null;
		SPEEDS = 1000;				//���ǵ� �缳��
		level = 1;					//���� �缳��
		start = true;				//�����÷��� true
		gameover = false;			//���ӿ��� �÷��� false
		preStyle = new Style(this, jpanel);	//������ ���� �ʱ�ȭ
		linecount = 0;				//������ ���� ī��Ʈ �ʱ�ȭ
		gamePoint = 0;				//��������Ʈ �ʱ�ȭ
	}
	//���ӿ���
	void gameOver() {
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] != null)
					blk[j][i].setImage("./images/block.png");
			}
		}
		System.out.print("gameOver");	//�ܼ�â�� ���
		gameover = true;	//���ӿ��� �÷��� ����
		now_speed = 1000;	//���� ���ǵ�� 1000���� �缳��
		jpanel.repaint();	//ȭ��׸���
	}
	//ä���� �� ã��
	void findLine() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.clear();
		int count;
		for(int i=0;i<HEIGHTS;i++) {
			count = 0;
			for(int j=0;j<WIDTHS;j++) {
				if(blk[j][i] != null && blk[j][i].isStop == true) {
					count++;
				}
			}
			if(count == WIDTHS) list.add(i);	//�� ä���� ���̸� add
		}
		
		//���� ���θ�ŭ �ݺ�
		for(int k=0;k<list.size();k++) {
			//�����
			for(int j=0;j<WIDTHS;j++) {
				blk[j][k] = null;
			}
			//��ĭ �Ʒ���
			for(int i=list.get(k)-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++) {
					blk[j][i+1] = blk[j][i];
					blk[j][i] = null;
				}
			}
		}
		
		gamePoint += (long)(list.size()*(100L * (long)level*3));	//��������
		linecount += list.size();	//������ ���� ����
		//20���� ������ ������
		if(linecount >= 10) {
			level += 1;
			SPEEDS -= 50;
			linecount = 0;
		}
	}
	//�����̴� �� ����
	void moveClear() {
		for(int i=HEIGHTS-1;i>=0;i--) {
			for(int j=0;j<WIDTHS;j++) {
				if(blk[j][i] != null && blk[j][i].isStop == false) {
					blk[j][i] = null;
				}
			}
		}
	}

	//��� �� ����(����)
	void allStop() {
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] != null) blk[j][i].isStop = true;
			}
		}
	}
	//��ĭ�� �Ʒ���
	void down() {
		if(!gameover) {
			//�̵� �������� Ȯ��(start�� false�̸� �̵�����)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++) {
					//���� null�� �ƴϰ�
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						if(i == HEIGHTS-1) {
							start = true;
							break;
						}
						
						//�������� �����ϰ� �����ִ°Ÿ� �����
						if(blk[j][i+1] != null && blk[j][i+1].isStop == true) {
							start = true;
							break;
						}
					}
				}
				if(start) break;
			}
			
			//�����ϸ� �̵�
			for(int i=HEIGHTS-1;i>=0;i--)
				for(int j=0;j<WIDTHS;j++)
					if(blk[j][i] != null && blk[j][i].isStop == false)
						if(!start) {
							//�Ʒ��� �̵�
							blk[j][i+1] = blk[j][i];
							blk[j][i] = null;
							
						}
			if(!start) posy += 1;	//������ġ����
	
			jpanel.repaint();	//ȭ��׸���
		}
	}
	
	//�ܼ�â ���
	void show() {
		System.out.println();
		System.out.println();
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] == null)
					System.out.print("��");
				else 
					System.out.print("��");
			}
			System.out.println();
		}
		System.out.print(gamePoint);	//�ܼ�â�� ����
		System.out.println("���� : "+level);
		System.out.println("���ǵ� : "+SPEEDS);
	}
	
	//�������� �̵�
	void left() {
		if(!gameover) {
			boolean flag = false;	//���� �÷���
			
			//�̵� �������� Ȯ��(flag�� false�̸� �̵�����)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++)	{
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						//���� ���� ��ġ�ϸ� �̵��Ұ�
						if(j == 0) {
							flag = true;
							break;
						}
						
						//���ʰŰ� �����ϰ� ������̸� �̵��Ұ�
						if(blk[j-1][i] != null && blk[j-1][i].isStop == true) {
							flag = true;
							break;
						}
						
					}
				}
				if(flag) break;
			}
			
			//�����ϸ� �̵�
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++)	{
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						if(!flag) {
							//�������� �̵�
							blk[j-1][i] = blk[j][i];
							blk[j][i] = null;
						}
					}
				}
			}
			if(!flag) posx -= 1;	//������ġ����
			jpanel.repaint();
		}
	}
	
	//���������� �̵�
	void right() {
		if(!gameover) {
			boolean flag = false;
			
			//�̵� �������� Ȯ��(flag�� false�̸� �̵�����)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=WIDTHS-1;j>=0;j--) {
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						//���� ���� ��ġ�ϸ� �̵��Ұ�
						if(j == WIDTHS-1) {
							flag = true;
							break;
						}
						
						//���ʰŰ� �����ϰ� ������̸� �̵��Ұ�
						if(blk[j+1][i] != null && blk[j+1][i].isStop == true) {
							flag = true;
							break;
						}
						
					}
				}
				if(flag) break;
			}
			
			//�����ϸ� �̵�
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=WIDTHS-1;j>=0;j--) {
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						if(!flag) {
							blk[j+1][i] = blk[j][i];
							blk[j][i] = null;
						}
						
					}
				}
				if(flag) break;
			}
			if(!flag) posx += 1;	//������ġ����
			jpanel.repaint();
		}
	}
}
