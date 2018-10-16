package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Mypage_Sell extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	//�з�(-1 �̸� ��κ���(��ۿϷ�� ����))
	String cate = "-1";
	int board_total;
	int board_cnt;

	int board_lengths;
	int board_starts;
	int board_ends;				//����������
	int board_paging;

	int pstarts;
	int pends;
	List list;

	@Override
	public String execute() throws Exception {
		super.run();
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		
		board_total = sdb.count2(member_info.getNo(), Integer.parseInt(cate));	//�� ����
		board_cnt = 0;						//no�� ���� ī��Ʈ

		board_lengths = 10;	//�ѹ��� ���� ����Ʈ ����
		board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		board_ends = board_starts+board_lengths-1;										//����������
		board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		pstarts = Integer.parseInt(pages)-5;
		pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		
		//����Ʈ ��������
		list = sdb.getArticles2(board_starts, board_ends, member_info.getNo(), Integer.parseInt(cate));

		request.setAttribute("cate", cate);
		request.setAttribute("list", list);
		
		
		return SUCCESS;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
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

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}


}
