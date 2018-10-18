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

public class Action_Mypage_List extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		paging = new Action_Paging(list_manager.getCount_M(searchs, searchs_value, member_info.getNo(), -1), 20, Integer.parseInt(pages));


		list = list_manager.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, member_info.getNo(), -1);	//리스트받아오기


		return SUCCESS;
	}

	public Action_Paging getPaging() {
		return paging;
	}

	public List getList() {
		return list;
	}

}
