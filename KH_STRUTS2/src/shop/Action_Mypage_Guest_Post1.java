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

public class Action_Mypage_Guest_Post1 extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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
		if(sgdb.changeStatus(no, 5)) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


}
