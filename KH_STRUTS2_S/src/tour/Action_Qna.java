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
import tour.data.Qna_Data;

public class Action_Qna extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	Action_Paging paging;
	int board_cnt = 0;
	int status = -1;
	
	//write_post
	String subject = "";
	String quest = "";
	
	//view,edit
	int no = -1;
	Qna_Data qdata;
	//int status = -1;
	
	//edit_post
	//int no = -1;
	//String subject = "";
	//String quest = "";
	//int status = -1;
	
	//del
	//int no = -1;
	//int status = -1;
	
	//answer
	//int no = -1;
	String answer = "";
	//int status = -1;
	
	//answer_del
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		//관리자면 1 아니면 내NO
		int member_no = -1;
		if(member_info.getOrders() != 3) member_no = member_info.getNo();
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map maps = new HashMap();
		maps.put("member_no", member_no);
		maps.put("status", status);
		int tmp = (int)sqlmap.queryForObject("Qna_getCount", maps);
		paging = new Action_Paging(tmp, 15, pages);
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		map.put("status", status);
		list = (List)sqlmap.queryForList("Qna_getArticles", map);
		
		return SUCCESS;
	}
	public String write() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			return ERROR;
		}
		
		Qna_Data qdata = new Qna_Data();
		qdata.setMember_no(member_info.getNo());
		qdata.setSubject(subject);
		qdata.setQuest(quest);
		qdata.setDates(year+"-"+month+"-"+day);
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.insert("Qna_insert", qdata);
		
		
		msg = "작성 성공";
		url = "qna.o";
		
		return SUCCESS;
	}
	public String view() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		qdata = (Qna_Data)sqlmap.queryForObject("Qna_getArticle", map);
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		qdata = (Qna_Data)sqlmap.queryForObject("Qna_getArticle", map);
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		Qna_Data qdatas = (Qna_Data)sqlmap.queryForObject("Qna_getArticle", map);
		
		if(qdatas.getMember_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		qdata.setSubject(subject);
		qdata.setQuest(quest);
		qdata.setDates(year+"-"+month+"-"+day);
		
		sqlmap.update("Qna_update", qdata);
		
		
		msg = "수정 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		
		return SUCCESS;
	}
	public String del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		Qna_Data qdatas = (Qna_Data)sqlmap.queryForObject("Qna_getArticle", map);
		
		if(qdatas.getMember_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		sqlmap.update("Qna_delete", map);
		
		
		msg = "삭제 성공";
		url = "qna.o?no="+no+"&pages="+pages+"&status="+status;
		
		return SUCCESS;
	}
	public String answer() throws Exception {
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
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		qdata.setAnswer(answer);
		qdata.setIsanswer(1);
		sqlmap.update("Qna_answer", qdata);
		
		msg = "답변 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		
		return SUCCESS;
	}
	public String answer_del() throws Exception {
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
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		sqlmap.update("Qna_answerDel", qdata);
		
		msg = "답변삭제 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Qna_Data getQdata() {
		return qdata;
	}
	public void setQdata(Qna_Data qdata) {
		this.qdata = qdata;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
