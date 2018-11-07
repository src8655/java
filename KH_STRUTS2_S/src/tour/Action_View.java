package tour;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.List_Data;
import tour.data.List_Reserve_Data;

public class Action_View extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	List_Data ldata;
	List list;
	int tab = 1;
	int pages_rv = 1;
	List list_review;
	Action_Paging paging;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		ldata = (List_Data)sqlmap.queryForObject("List_getArticle", no);
		list = (List)sqlmap.queryForList("List_Reserve_getArticles", no);
		
		//조회수 처리
		Cookie_Bean cb = Cookie_Bean.getInstance();
		cb.view_cookie(no, request, response);
		
		//최근본상품 처리
		cb.viewed_cookie(no, request, response);
		
		
		Map map = new HashMap();
		map.put("list_no", no);
		int tmp = (int)sqlmap.queryForObject("Review_getCount", map);
		paging = new Action_Paging(tmp, 10, pages_rv);
		map.clear();
		map.put("list_no", no);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list_review = (List)sqlmap.queryForList("Review_getArticles", map);
		
		
		for(int i=0;i<list.size();i++) {
			List_Reserve_Data lrdata = (List_Reserve_Data)list.get(i);
			long tmp_now = cal.getTimeInMillis()/1000;
			long tmp_after = Long.parseLong(lrdata.getTimes())/1000;
			long tmp_result = tmp_after - tmp_now;
			
			//시간차 저장
			lrdata.setTimes_tmp(Long.toString(tmp_result));
		}
		
		
		
		return SUCCESS;
	}

	public List_Data getLdata() {
		return ldata;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public List getList() {
		return list;
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}

	public int getPages_rv() {
		return pages_rv;
	}

	public void setPages_rv(int pages_rv) {
		this.pages_rv = pages_rv;
	}

	public List getList_review() {
		return list_review;
	}

	public Action_Paging getPaging() {
		return paging;
	}
	
}
