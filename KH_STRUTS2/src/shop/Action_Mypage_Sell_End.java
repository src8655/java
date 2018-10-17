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

public class Action_Mypage_Sell_End extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int board_total;
	int board_cnt;

	int board_lengths;
	int board_starts;
	int board_ends;
	int board_paging;

	int pstarts;
	int pends;
	List list;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
							
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		
		board_total = sdb.count2_M(member_info.getNo(), 5);	//총 개수
		board_cnt = 0;						//no를 위한 카운트

		board_lengths = 10;	//한번에 보일 리스트 개수
		board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
		board_ends = board_starts+board_lengths-1;										//마지막지점
		board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

		pstarts = Integer.parseInt(pages)-5;
		pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;


		//리스트 가져오기
		list = sdb.getArticles2_M(board_starts, board_ends, member_info.getNo(), 5);

		
		
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

}
