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
	Action_Paging paging;
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
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), 5), 10, Integer.parseInt(pages));

		//리스트 가져오기
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), 5);

		
		
		return SUCCESS;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public List getList() {
		return list;
	}

}
