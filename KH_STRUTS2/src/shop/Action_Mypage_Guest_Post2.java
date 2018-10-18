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

public class Action_Mypage_Guest_Post2 extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


}
