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
import tour.data.Notice_Data;

public class Action_Notice extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	Action_Paging paging;
	int board_cnt = 0;
	
	//write_post
	String subject = "";
	String memo = "";
	
	//view,edit
	int no = -1;
	Notice_Data ndata;
	
	//edit_post
	//String subject = "";
	//String memo = "";
	//int no = -1;
	
	//del
	//int no = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		int tmp = (int)sqlmap.queryForObject("Notice_getCount");
		paging = new Action_Paging(tmp, 10, pages);
		Map map = new HashMap();
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list = (List)sqlmap.queryForList("Notice_getArticles", map);
		
		return SUCCESS;
	}
	public String write() throws Exception {
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
		
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
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
		
		Notice_Data ndata = new Notice_Data();
		ndata.setSubject(subject);
		ndata.setMemo(memo);
		ndata.setDates(year+"-"+month+"-"+day);
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.insert("Notice_insert", ndata);
		
		msg = "작성 성공";
		url = "notice.o";
		
		return SUCCESS;
	}
	public String view() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		ndata = (Notice_Data)sqlmap.queryForObject("Notice_getArticle", map);
		
		return SUCCESS;
	}
	public String edit() throws Exception {
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
		ndata = (Notice_Data)sqlmap.queryForObject("Notice_getArticle", map);
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
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
		
		Notice_Data ndata = new Notice_Data();
		ndata.setNo(no);
		ndata.setSubject(subject);
		ndata.setMemo(memo);
		ndata.setDates(year+"-"+month+"-"+day);
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.update("Notice_update", ndata);
		
		msg = "수정 성공";
		url = "notice_view.o?no="+no+"&pages="+pages;
		
		return SUCCESS;
	}
	public String del() throws Exception {
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
		
		Notice_Data ndata = new Notice_Data();
		ndata.setNo(no);
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.delete("Notice_delete", ndata);
		
		msg = "삭제 성공";
		url = "notice.o?pages="+pages;
		
		return SUCCESS;
	}
	public List getList() {
		return list;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Notice_Data getNdata() {
		return ndata;
	}
	public void setNdata(Notice_Data ndata) {
		this.ndata = ndata;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	
}
