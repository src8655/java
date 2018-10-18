package shop;

public class Action_Paging {
	private int board_total;	//�� ����
	private int board_cnt;		//no�� ���� ī��Ʈ
	private int board_lengths;	//�ѹ��� ���� ����Ʈ ����
	private int board_starts;	//����
	private int board_ends;		//����
	private int board_paging;	//����¡ ������
	private int pstarts;
	private int pends;
	private int pages;
	
	public Action_Paging(int board_total, int board_lengths, int pages) {
		this.board_total = board_total;
		this.board_lengths = board_lengths;
		this.pages = pages;
		
		board_cnt = 0;																//no�� ���� ī��Ʈ
		board_starts = (pages*board_lengths)-board_lengths+1;						//��������
		board_ends = board_starts+board_lengths-1;									//����������
		board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����
		pstarts = pages-5;
		pends = pages+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
	}

	public int getBoard_total() {
		return board_total;
	}

	public void setBoard_total(int board_total) {
		this.board_total = board_total;
	}

	public int getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}

	public int getBoard_lengths() {
		return board_lengths;
	}

	public void setBoard_lengths(int board_lengths) {
		this.board_lengths = board_lengths;
	}

	public int getBoard_starts() {
		return board_starts;
	}

	public void setBoard_starts(int board_starts) {
		this.board_starts = board_starts;
	}

	public int getBoard_ends() {
		return board_ends;
	}

	public void setBoard_ends(int board_ends) {
		this.board_ends = board_ends;
	}

	public int getBoard_paging() {
		return board_paging;
	}

	public void setBoard_paging(int board_paging) {
		this.board_paging = board_paging;
	}

	public int getPstarts() {
		return pstarts;
	}

	public void setPstarts(int pstarts) {
		this.pstarts = pstarts;
	}

	public int getPends() {
		return pends;
	}

	public void setPends(int pends) {
		this.pends = pends;
	}
	
}
