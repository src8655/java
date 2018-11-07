package tour;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.*;

public class Action_List_S extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	String startdates = "";
	int days = 0;
	int money = 0;
	Action_Paging paging;
	String subject = "";
	String subject_utf = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		subject_utf = URLEncoder.encode(subject,"UTF-8");
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("startdates", startdates);
		map.put("days", days);
		map.put("category", category);
		map.put("money", money);
		map.put("subject", subject);
		
		int tmp = (int)sqlmap.queryForObject("List_Reserve_getCountAll", map);
		paging = new Action_Paging(tmp, 2, pages);
		map.clear();
		map.put("startdates", startdates);
		map.put("days", days);
		map.put("category", category);
		map.put("money", money);
		map.put("subject", subject);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list = (List)sqlmap.queryForList("List_Reserve_getArticlesAll", map);
		
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getStartdates() {
		return startdates;
	}
	public void setStartdates(String startdates) {
		this.startdates = startdates;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubject_utf() {
		return subject_utf;
	}
	public void setSubject_utf(String subject_utf) {
		this.subject_utf = subject_utf;
	}

	
    
}
