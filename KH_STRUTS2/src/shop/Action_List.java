package shop;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_List extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int board_total;
	int board_cnt;

	int board_lengths;
	int board_starts;
	int board_ends;
	int board_paging;

	int pstarts;
	int pends;

	List list;
	String date;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		
		board_total = list_manager.getCount(searchs, searchs_value, -1, order);	//�� ����
		board_cnt = 0;						//no�� ���� ī��Ʈ

		board_lengths = 20;	//�ѹ��� ���� ����Ʈ ����
		board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		board_ends = board_starts+board_lengths-1;										//����������
		board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		pstarts = Integer.parseInt(pages)-5;
		pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		

		list = list_manager.getArticles(board_starts, board_ends, searchs, searchs_value, 10, -1, order);	//����Ʈ�޾ƿ���

		date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
		
		return SUCCESS;
	}

	public int getBoard_total() {
		return board_total;
	}

	public int getBoard_cnt() {
		return board_cnt;
	}

	public int getBoard_lengths() {
		return board_lengths;
	}

	public int getBoard_starts() {
		return board_starts;
	}

	public int getBoard_ends() {
		return board_ends;
	}

	public int getBoard_paging() {
		return board_paging;
	}

	public int getPstarts() {
		return pstarts;
	}

	public int getPends() {
		return pends;
	}

	public List getList() {
		return list;
	}

	public String getDate() {
		return date;
	}
	
}
