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

public class Action_Customer_Center_Qna extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list = null;
	
	//write_post
	int category = -1;
	String subject = "";
	String memo = "";
	int res = 0;
	
	//view,edit
	int no = -1;
	Qna_Data_Bean qdata;
	
	//edit_post
	/*int no = -1;
	int category = -1;
	String subject = "";
	String memo = "";*/
	
	//del
	//int no = -1;
	
	//answer
	//int no = -1;
	String answer = "";
	
	//answer_del
	//int no = -1;
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		//관리자면 -1 회원이면 회원번호
		if(member_info.getOrders() == 3) paging = new Action_Paging(qdb.count_M(-1), 10, Integer.parseInt(pages));	//관리자일때
		else paging = new Action_Paging(qdb.count_M(member_info.getNo()), 10, Integer.parseInt(pages));			//아닐때
		

		//리스트받아오기
		if(member_info.getOrders() == 3) list = qdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, -1);
		else list = qdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, member_info.getNo());

		return SUCCESS;
	}
	public String write() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}


		if(category == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "문의제목을 입력해주세요.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "문의내용을 입력해주세요.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setCategory(category);
		qdata.setSubject(subject);
		qdata.setMemo(memo);
		qdata.setDates(year+"-"+month+"-"+day);
		qdata.setGuest_no(member_info.getNo());
		
		
		
		if(qdb.insert_M(qdata)) res = 1;
		
		if(res == 1) {
			msg = "작성 완료.";
			url = "customer_center_qna.o";
			return SUCCESS;
		}else{
			msg = "작성실패";
			return ERROR;
		}
	}
	public String view() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		qdata = qdb.getArticle_M(no);
		
		//관리자도아닌데
		if(member_info.getOrders() != 3)
			if(qdata.getGuest_no() != member_info.getNo()) {
				//내 자료가 아닌걸 보면 안됨
				msg = "잘못된 접근입니다.";
				return ERROR;
			}
		
		
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		qdata = qdb.getArticle_M(no);
		
		//내 게시글이 아니면
		if(qdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(category == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "문의제목을 입력해주세요.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "문의내용을 입력해주세요.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setNo(no);
		qdata.setCategory(category);
		qdata.setSubject(subject);
		qdata.setMemo(memo);
		qdata.setDates(year+"-"+month+"-"+day);
		qdata.setGuest_no(member_info.getNo());
		
		
		int res = 0;
		if(qdb.update_M(qdata)) res = 1;
		
		
		
		if(res == 1) {
			msg = "수정 완료";
			url = "customer_center_qna.o";
			return SUCCESS;
		}else{
			msg = "수정 실패.";
			return ERROR;
		}
	}
	public String del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		
		int res = 0;
		if(qdb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "삭제 완료";
			url = "customer_center_qna.o?pages="+pages;
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "삭제 실패";
			return ERROR;
		}
		return null;
	}
	public String answer() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "문의답변을 입력해주세요.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setNo(no);
		qdata.setIsanswer(1);
		qdata.setAnswer(answer);
		
		
		int res = 0;
		if(qdb.answer_M(qdata)) res = 1;
		
		
		
		if(res == 1) {
			msg = "답변작성 완료.";
			url = "customer_center_qna_view.o?no="+no+"&pages="+pages;
			return SUCCESS;
		}else{
			msg = "답변작성 실패.";
			return ERROR;
		}
	}
	public String answer_del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		
		int res = 0;
		if(qdb.answerDel_M(no)) res = 1;
		
		
		
		if(res == 1) {
			msg = "답변삭제 완료";
			url = "customer_center_qna_view.o?pages="+pages+"&no="+no;
			return SUCCESS;
		}else{
			msg = "답변삭제 실패";
			return ERROR;
		}
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
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
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Qna_Data_Bean getQdata() {
		return qdata;
	}
	public void setQdata(Qna_Data_Bean qdata) {
		this.qdata = qdata;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
