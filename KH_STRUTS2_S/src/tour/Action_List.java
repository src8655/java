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

public class Action_List extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list = new ArrayList();
	int cnt = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map1 = new HashMap();
		map1.put("category", category);
		map1.put("searchs", searchs);
		int count = (int)sqlmap.queryForObject("List_getCount", map1);
		paging = new Action_Paging(count, 6, pages);
		
		Map map2 = new HashMap();
		map2.put("start", paging.getBoard_starts());
		map2.put("end", paging.getBoard_ends());
		map2.put("category", category);
		map2.put("searchs", searchs);
		
		list = sqlmap.queryForList("List_getArticles", map2);
		
		//글자 사이즈 바꾸기
		int maxsize = 22;
		for(int i=0;i<list.size();i++) {
			List_Data ldata = (List_Data)list.get(i);
			if(ldata.getSubject().length() > maxsize)
				ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		
		return SUCCESS;
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

	public int getCnt() {
		return cnt;
	}
	
}
