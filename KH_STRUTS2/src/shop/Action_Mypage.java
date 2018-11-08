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

public class Action_Mypage extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	
	//sell
	//분류(-1 이면 모두보기(배송완료는 제외))
	String cate = "-1";
	Action_Paging paging;
	List list;
	
	//sell_post
	int no = -1;
	int status = -1;
	//String cate = "-1";
	String ship_num = "";
	
	//sell_end
	//Action_Paging paging;
	//List list;
	
	//list
	//Action_Paging paging;
	//List list;

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
		
		
		return SUCCESS;
	}
	public String sell() throws Exception {
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
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), Integer.parseInt(cate)), 10, Integer.parseInt(pages));
		
		//리스트 가져오기
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), Integer.parseInt(cate));

		
		
		return SUCCESS;
	}
	public String sell_post() throws Exception {
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
		

		//상태변경
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		int res = 0;
		
		//입금완료(2)상태이면
		if(status == 2) {
			if(sdb.changeStatus_M(no, 3)) res = 1;
		}
		//배송준비중(3)상태이면
		if(status == 3) {
			//운송장번호가 없으면 취소
			if(ship_num.equals("")) {
				msg = "운송장번호를 입력해주세요.";
				return ERROR;
			}
			if(sdb.changeShipStatus_M(no, ship_num)) res = 1;
		}
		
		if(res == 1) {
			msg = "수정 완료.";
			url = "mypage_sell.o?pages="+pages+"&cate="+cate;
					
			return SUCCESS;
		}else{
			msg = "수정 실패.";
			return ERROR;
		}
		
	}
	public String sell_end() throws Exception {
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
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), 5), 10, Integer.parseInt(pages));

		//리스트 가져오기
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), 5);

		
		
		return SUCCESS;
	}
	public String list() throws Exception {
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
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		paging = new Action_Paging(list_manager.getCount_M(searchs, searchs_value, member_info.getNo(), -1), 20, Integer.parseInt(pages));


		list = list_manager.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, member_info.getNo(), -1);	//리스트받아오기


		return SUCCESS;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getShip_num() {
		return ship_num;
	}
	public void setShip_num(String ship_num) {
		this.ship_num = ship_num;
	}
	
}
