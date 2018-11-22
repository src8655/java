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
	
	//view
	String times = "";
	Sell_Group_Data_Bean sgdata;
	//List list;
	
	//post2,post1
	int no = -1;
	
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
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count_M2(paging.getBoard_starts(), paging.getBoard_ends(), sdata.getTimes(), sdata.getGuest_no()));
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
	public String view() throws Exception {
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
		
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		sgdata = sgdb.getArticle_M(times);
			

		//금액형태로 바꾸기
		sgdata.setMoneys(number_format(sgdata.getMoney()));
		sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
		sgdata.setRmoneys(number_format(sgdata.getRmoney()));
		sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
		sgdata.setPoints(number_format(sgdata.getPoint()));
		
		
		//내용부분
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		list = sdb.getArticles3_M(sgdata.getTimes());
		
		//중복된것 카운트
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//새로운게 나오면 같은 그룹의 개수만큼 rowspan값을 지정
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count_M(sdata.getTimes()));
			tmp = sdata.getTimes();
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		return SUCCESS;
	}
	public String post2() throws Exception {
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
		
		//내꺼인지 확인
		Sell_Data_Bean sdata = sdb.getArticle_M(no);
		
		//내꺼가아니면
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		//상태가 입금대기중이 아니면
		if(sdata.getStatus() != 1) {
			msg = "입금대기중 상태에서만 취소가 가능합니다.";
			return ERROR;
		}
		
		
		//포인트 적용된 그룹인지 아닌지 확인
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		Sell_Group_Data_Bean sgdata = sgdb.getArticle_M(sdata.getTimes());
		if(sgdata.getPoint() != 0) {
			/*
			response.getWriter().println("<script>");
			response.getWriter().println("alert('적용된 포인트가 취소됩니다.')");
			response.getWriter().println("</script>");
			*/
			//포인트 돌려주기
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint_M(member_info.getNo(), member_info.getPoint() + sgdata.getPoint());
			sgdb.setPoint_M(sgdata.getNo(), 0);
		}
		
		
		//
		int res = 0;
		if(sdb.delete_M(sdata)) res = 1;
		
		
		if(res == 1) {
			msg = "취소 성공.";
			url = "mypage_guest.o?pages="+pages;
			return SUCCESS;
		}else{
			msg = "취소 실패.";
			return ERROR;
		}
	}
	public String post1() throws Exception {
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
		

		Sell_DB_Bean sgdb = Sell_DB_Bean.getInstance();
		
		//내꺼인지 확인
		Sell_Data_Bean sdata = sgdb.getArticle_M(no);
		
		//내꺼가아니면
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		//상태를 배송완료로 설정
		int res = 0;
		if(sgdb.changeStatus_M(no, 5)) {
			res = 1;
			
			//구매확정 완료 후 에는 해당 제품에 구매 카운트를 추가함
			List_DB_Bean ldb = List_DB_Bean.getInstance();
			ldb.addBuy_M(sdata.getProduct_no());
			
			//구매확정시 회원 포인트를 구매금액의 3% 적립
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint_M(member_info.getNo(), member_info.getPoint() + (int)(((double)sdata.getRmoney())*(3.0/100.0)));
		}
		
		if(res == 1) {
			msg = "구매확정 성공.";
			url = "mypage_guest.o?pages="+pages;
			return SUCCESS;
		}else{
			msg = "구매확정 실패.";
			return ERROR;
		}
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
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Sell_Group_Data_Bean getSgdata() {
		return sgdata;
	}
	public void setSgdata(Sell_Group_Data_Bean sgdata) {
		this.sgdata = sgdata;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
