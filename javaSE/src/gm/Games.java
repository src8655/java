package gm;

import java.util.ArrayList;
import javax.swing.JPanel;

class Games extends Thread {
	final static int WIDTHS = 10;		//화면너비
	final static int HEIGHTS = 27;		//화면높이
	public Block[][] blk = new Block[WIDTHS][HEIGHTS];	//블럭 칸
	public Block[][] preblk = new Block[6][6];			//이전 블럭 칸
	public boolean start = true;		//시작
	public int posx = 4;				//블럭 위치 x
	public int posy = 1;				//블럭 위치y
	public int SPEEDS = 1000;			//스피드
	public int now_speed = 1000;		//현재 스피드
	public boolean gameover = false;	//게임오버 플래그
	public int level = 1;				//레벨
	public long gamePoint = 0;			//점수
	public int linecount = 0;			//없어진 라인 카운트(20줄마다 레벨 갱신)
	public Style preStyle;				//이전 블럭 모양
	public Style nowStyle;				//현재 블럭 모양
	public JPanel jpanel;
	
	Games(JPanel jpanel) {
		this.jpanel = jpanel;
		preStyle = new Style(this, this.jpanel);
	}
	@Override
	public void run() {
		while(true) {
			//게임오버 플래그가 false일때만 작동
			if(!gameover) {
				if(start) {
					allStop();					//모든 블럭 멈춘블럭으로
					findLine();					//가로로 채워진 블럭라인 찾기
					posx = 4;					//첫 위치로
					posy = 1;
					start = false;				//시작플래그를 false
					nowStyle = preStyle;		//현재 블럭모양으로 바꿈
					preStyle = new Style(this, jpanel);	//이전 블럭모양을 생성
					nowStyle.draw();			//현재블럭 모양을 그리기
					preStyle.predraw();			//이전블럭 모양을 그리기
					now_speed = SPEEDS;			//스피드를 현재 스피드로 설정
				}
				down();	//한칸씩 내려온다
			}
			show();	//콘솔에 출력
			try {
				Thread.sleep(now_speed);// 현재 스피드만큼 스레드 대기
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	//다시시작
	public void replay() {
		//모든블럭 초기화
		for(int i=0;i<HEIGHTS;i++)
			for(int j=0;j<WIDTHS;j++)
				blk[j][i] = null;
		SPEEDS = 1000;				//스피드 재설정
		level = 1;					//레벨 재설정
		start = true;				//시작플래그 true
		gameover = false;			//게임오버 플래그 false
		preStyle = new Style(this, jpanel);	//이전블럭 새로 초기화
		linecount = 0;				//없어진 라인 카운트 초기화
		gamePoint = 0;				//게임포인트 초기화
	}
	//게임오버
	void gameOver() {
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] != null)
					blk[j][i].setImage("./images/block.png");
			}
		}
		System.out.print("gameOver");	//콘솔창에 출력
		gameover = true;	//게임오버 플래그 갱신
		now_speed = 1000;	//현재 스피드는 1000으로 재설정
		jpanel.repaint();	//화면그리기
	}
	//채워진 줄 찾기
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
			if(count == WIDTHS) list.add(i);	//다 채워진 줄이면 add
		}
		
		//지울 라인만큼 반복
		for(int k=0;k<list.size();k++) {
			//지우고
			for(int j=0;j<WIDTHS;j++) {
				blk[j][k] = null;
			}
			//한칸 아래로
			for(int i=list.get(k)-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++) {
					blk[j][i+1] = blk[j][i];
					blk[j][i] = null;
				}
			}
		}
		
		gamePoint += (long)(list.size()*(100L * (long)level*3));	//점수갱신
		linecount += list.size();	//없어진 라인 누적
		//20라인 누적시 레벨업
		if(linecount >= 10) {
			level += 1;
			SPEEDS -= 50;
			linecount = 0;
		}
	}
	//움직이는 블럭 삭제
	void moveClear() {
		for(int i=HEIGHTS-1;i>=0;i--) {
			for(int j=0;j<WIDTHS;j++) {
				if(blk[j][i] != null && blk[j][i].isStop == false) {
					blk[j][i] = null;
				}
			}
		}
	}

	//모든 블럭 멈춤(고정)
	void allStop() {
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] != null) blk[j][i].isStop = true;
			}
		}
	}
	//한칸씩 아래로
	void down() {
		if(!gameover) {
			//이동 가능한지 확인(start가 false이면 이동가능)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++) {
					//현재 null이 아니고
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						if(i == HEIGHTS-1) {
							start = true;
							break;
						}
						
						//다음꺼가 존재하고 멈춰있는거면 재시작
						if(blk[j][i+1] != null && blk[j][i+1].isStop == true) {
							start = true;
							break;
						}
					}
				}
				if(start) break;
			}
			
			//가능하면 이동
			for(int i=HEIGHTS-1;i>=0;i--)
				for(int j=0;j<WIDTHS;j++)
					if(blk[j][i] != null && blk[j][i].isStop == false)
						if(!start) {
							//아래로 이동
							blk[j][i+1] = blk[j][i];
							blk[j][i] = null;
							
						}
			if(!start) posy += 1;	//현재위치갱신
	
			jpanel.repaint();	//화면그리기
		}
	}
	
	//콘솔창 출력
	void show() {
		System.out.println();
		System.out.println();
		for(int i=0;i<HEIGHTS;i++) {
			for(int j=0;j<WIDTHS;j++)	{
				if(blk[j][i] == null)
					System.out.print("□");
				else 
					System.out.print("■");
			}
			System.out.println();
		}
		System.out.print(gamePoint);	//콘솔창에 점수
		System.out.println("레벨 : "+level);
		System.out.println("스피드 : "+SPEEDS);
	}
	
	//왼쪽으로 이동
	void left() {
		if(!gameover) {
			boolean flag = false;	//정지 플래그
			
			//이동 가능한지 확인(flag가 false이면 이동가능)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++)	{
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						//왼쪽 벽에 위치하면 이동불가
						if(j == 0) {
							flag = true;
							break;
						}
						
						//왼쪽거가 존재하고 멈춘블럭이면 이동불가
						if(blk[j-1][i] != null && blk[j-1][i].isStop == true) {
							flag = true;
							break;
						}
						
					}
				}
				if(flag) break;
			}
			
			//가능하면 이동
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=0;j<WIDTHS;j++)	{
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						if(!flag) {
							//왼쪽으로 이동
							blk[j-1][i] = blk[j][i];
							blk[j][i] = null;
						}
					}
				}
			}
			if(!flag) posx -= 1;	//현재위치갱신
			jpanel.repaint();
		}
	}
	
	//오른쪽으로 이동
	void right() {
		if(!gameover) {
			boolean flag = false;
			
			//이동 가능한지 확인(flag가 false이면 이동가능)
			for(int i=HEIGHTS-1;i>=0;i--) {
				for(int j=WIDTHS-1;j>=0;j--) {
					if(blk[j][i] != null && blk[j][i].isStop == false) {
						//왼쪽 벽에 위치하면 이동불가
						if(j == WIDTHS-1) {
							flag = true;
							break;
						}
						
						//왼쪽거가 존재하고 멈춘블럭이면 이동불가
						if(blk[j+1][i] != null && blk[j+1][i].isStop == true) {
							flag = true;
							break;
						}
						
					}
				}
				if(flag) break;
			}
			
			//가능하면 이동
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
			if(!flag) posx += 1;	//현재위치갱신
			jpanel.repaint();
		}
	}
}
