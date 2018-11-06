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
import tour.data.Reserve_Data;

public class Action_Admin_Reserve extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	Action_Paging paging;
	int status = -1;
	
	//view
	int no = -1;
	Reserve_Data rdata;
	//int status = -1;
	
	//pay
	//int no = -1;
	//int status = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("status", status);
		int tmp = (int)sqlmap.queryForObject("Reserve_getCountAll", map);
		paging = new Action_Paging(tmp, 10, pages);
		map.clear();
		map.put("status", status);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list = (List)sqlmap.queryForList("Reserve_getArticlesAll", map);
		
		return SUCCESS;
	}
	public String view() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		
		rdata = (Reserve_Data)sqlmap.queryForObject("Reserve_getArticle", no);
		
		
		return SUCCESS;
	}
	public String pay() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		map.put("status", 2);
		sqlmap.update("Reserve_setStatus", map);
		
		msg = "입금확인 완료";
		url = "admin_reserve.o?pages="+pages+"&status="+status+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	
	public List getList() {
		return list;
	}

	public Action_Paging getPaging() {
		return paging;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Reserve_Data getRdata() {
		return rdata;
	}
	public void setRdata(Reserve_Data rdata) {
		this.rdata = rdata;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	
}
