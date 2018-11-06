package tour;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import tour.data.Notice_Data;

public class Action_Index extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list_special;
	List list_hit;
	List list_hit1;
	List list_hit2;
	List list_hit3;
	List list_hit4;
	List list_hit5;
	List list_hit6;
	List list_hit7;
	List list_buy;
	List_Data ldata_hot;
	List list_notice;

	@Override
	public String execute() throws Exception {
		super.run();
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		list_special = (List)sqlmap.queryForList("List_Reserve_getArticlesMain", 5);
		
		//글자 사이즈 바꾸기
		int maxsize = 9;
		for(int i=0;i<list_special.size();i++) {
			List_Reserve_Data lrdata = (List_Reserve_Data)list_special.get(i);
			if(lrdata.getSubject().length() > maxsize)
				lrdata.setSubject(lrdata.getSubject().substring(0, maxsize)+"...");
			String[] tmp = lrdata.getStartdates().split("-");
			if(tmp.length >= 3) lrdata.setStartdates(tmp[1]+"/"+tmp[2]);
		}
		
		
		Map map = new HashMap();
		map.put("start", 0);
		map.put("end", 4);

		map.put("category", -1);
		list_hit = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 1);
		list_hit1 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 2);
		list_hit2 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 3);
		list_hit3 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 4);
		list_hit4 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 5);
		list_hit5 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 6);
		list_hit6 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		map.put("category", 7);
		list_hit7 = (List)sqlmap.queryForList("List_getArticlesHit", map);
		
		maxsize = 15;
		for(int i=0;i<list_hit.size();i++) {
			List_Data ldata = (List_Data)list_hit.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit1.size();i++) {
			List_Data ldata = (List_Data)list_hit1.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit2.size();i++) {
			List_Data ldata = (List_Data)list_hit2.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit3.size();i++) {
			List_Data ldata = (List_Data)list_hit3.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit4.size();i++) {
			List_Data ldata = (List_Data)list_hit4.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit5.size();i++) {
			List_Data ldata = (List_Data)list_hit5.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit6.size();i++) {
			List_Data ldata = (List_Data)list_hit6.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit7.size();i++) {
			List_Data ldata = (List_Data)list_hit7.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		map.clear();
		map.put("start", 0);
		map.put("end", 4);
		list_buy = (List)sqlmap.queryForList("List_getArticlesBuy", map);

		for(int i=0;i<list_buy.size();i++) {
			List_Data ldata = (List_Data)list_buy.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		
		List list_tmp = (List)sqlmap.queryForList("List_getArticleHot");
		if(list_tmp.size()>=1) ldata_hot = (List_Data)list_tmp.get(0);
		if(ldata_hot == null) ldata_hot = new List_Data();
		
		
		map.clear();
		map.put("start", 0);
		map.put("end", 5);
		list_notice = (List)sqlmap.queryForList("Notice_getArticlesMain", map);
		
		maxsize = 16;
		for(int i=0;i<list_notice.size();i++) {
			Notice_Data ndata = (Notice_Data)list_notice.get(i);
			if(ndata.getSubject().length() > maxsize) ndata.setSubject(ndata.getSubject().substring(0, maxsize)+"...");
		}
		
		return SUCCESS;
	}

	public List getList_special() {
		return list_special;
	}

	public List getList_hit() {
		return list_hit;
	}

	public List getList_hit1() {
		return list_hit1;
	}

	public List getList_hit2() {
		return list_hit2;
	}

	public List getList_hit3() {
		return list_hit3;
	}

	public List getList_hit4() {
		return list_hit4;
	}

	public List getList_hit5() {
		return list_hit5;
	}

	public List getList_hit6() {
		return list_hit6;
	}

	public List getList_hit7() {
		return list_hit7;
	}

	public List getList_buy() {
		return list_buy;
	}

	public List_Data getLdata_hot() {
		return ldata_hot;
	}

	public List getList_notice() {
		return list_notice;
	}

	public void setList_notice(List list_notice) {
		this.list_notice = list_notice;
	}
	
}
