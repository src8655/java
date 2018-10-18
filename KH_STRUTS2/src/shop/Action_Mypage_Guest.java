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

public class Action_Mypage_Guest extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list;

	int process1;
	int process2;
	int process3;
	int process4;
	int process5;
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		paging = new Action_Paging(sdb.count_M(member_info.getNo()), 7, Integer.parseInt(pages));
		
		list = sdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo());
		
		//중복된것 카운트
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//새로운게 나오면 같은 그룹의 개수만큼 rowspan값을 지정
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count(paging.getBoard_starts(), paging.getBoard_ends(), sdata.getTimes(), sdata.getGuest_no()));
			tmp = sdata.getTimes();
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		
		//진행중인주문 개수
		process1 = sdb.guest_sell_count_M(member_info.getNo(), 1);
		process2 = sdb.guest_sell_count_M(member_info.getNo(), 2);
		process3 = sdb.guest_sell_count_M(member_info.getNo(), 3);
		process4 = sdb.guest_sell_count_M(member_info.getNo(), 4);
		process5 = sdb.guest_sell_count_M(member_info.getNo(), 5);
		
		return SUCCESS;
	}

	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
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

	public int getProcess1() {
		return process1;
	}

	public void setProcess1(int process1) {
		this.process1 = process1;
	}

	public int getProcess2() {
		return process2;
	}

	public void setProcess2(int process2) {
		this.process2 = process2;
	}

	public int getProcess3() {
		return process3;
	}

	public void setProcess3(int process3) {
		this.process3 = process3;
	}

	public int getProcess4() {
		return process4;
	}

	public void setProcess4(int process4) {
		this.process4 = process4;
	}

	public int getProcess5() {
		return process5;
	}

	public void setProcess5(int process5) {
		this.process5 = process5;
	}
}
