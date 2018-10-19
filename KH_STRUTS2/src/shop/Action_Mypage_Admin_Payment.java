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

public class Action_Mypage_Admin_Payment extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		//입금대기상태의 리스트가져오기
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		list = sgdb.getPayArticles_M(1);
		
		
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

}
