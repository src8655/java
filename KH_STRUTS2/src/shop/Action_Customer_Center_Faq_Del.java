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

public class Action_Customer_Center_Faq_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int category = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		
		
		int res = 0;
		if(fdb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "삭제 완료.";
			url = "customer_center_faq.o?pages="+pages+"&category="+category+"&p_search="+p_search+"&p_search_value="+p_search_values;
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "삭제 실패.";
			return ERROR;
		}
		return null;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}


}
