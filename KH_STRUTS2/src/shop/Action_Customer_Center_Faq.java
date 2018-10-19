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

public class Action_Customer_Center_Faq extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int category = -1;
	Action_Paging paging;
	List list;
	int board_cnt = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		paging = new Action_Paging(fdb.count_M(p_search, p_search_value, category), 10, Integer.parseInt(pages));
		

		list = fdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), p_search, p_search_value, category);
		
		return SUCCESS;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public List getList() {
		return list;
	}

	public int getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	
}
