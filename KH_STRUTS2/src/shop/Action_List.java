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

public class Action_List extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;

	List list;
	
	@Override
	public String execute() throws Exception {
		super.run();

		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		paging = new Action_Paging(list_manager.getCount_M(searchs, searchs_value, -1, order), 20, Integer.parseInt(pages));

		list = list_manager.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, -1, order);	//리스트받아오기

		return SUCCESS;
	}

	public List getList() {
		return list;
	}


	public Action_Paging getPaging() {
		return paging;
	}
}
