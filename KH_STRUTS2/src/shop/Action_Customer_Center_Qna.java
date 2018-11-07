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
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		//�����ڸ� -1 ȸ���̸� ȸ����ȣ
		if(member_info.getOrders() == 3) paging = new Action_Paging(qdb.count_M(-1), 10, Integer.parseInt(pages));	//�������϶�
		else paging = new Action_Paging(qdb.count_M(member_info.getNo()), 10, Integer.parseInt(pages));			//�ƴҶ�
		

		//����Ʈ�޾ƿ���
		if(member_info.getOrders() == 3) list = qdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, -1);
		else list = qdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, member_info.getNo());

		return SUCCESS;
	}
	public String write() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}


		if(category == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "���������� �Է����ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "���ǳ����� �Է����ּ���.";
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
			msg = "�ۼ� �Ϸ�.";
			url = "customer_center_qna.o";
			return SUCCESS;
		}else{
			msg = "�ۼ�����";
			return ERROR;
		}
	}
	public String view() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		qdata = qdb.getArticle_M(no);
		
		//�����ڵ��ƴѵ�
		if(member_info.getOrders() != 3)
			if(qdata.getGuest_no() != member_info.getNo()) {
				//�� �ڷᰡ �ƴѰ� ���� �ȵ�
				msg = "�߸��� �����Դϴ�.";
				return ERROR;
			}
		
		
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		qdata = qdb.getArticle_M(no);
		
		//�� �Խñ��� �ƴϸ�
		if(qdata.getGuest_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}

		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(category == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "���������� �Է����ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "���ǳ����� �Է����ּ���.";
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
			msg = "���� �Ϸ�";
			url = "customer_center_qna.o";
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
	}
	public String del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		

		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		
		int res = 0;
		if(qdb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "���� �Ϸ�";
			url = "customer_center_qna.o?pages="+pages;
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "���� ����";
			return ERROR;
		}
		return null;
	}
	public String answer() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}

		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "���Ǵ亯�� �Է����ּ���.";
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
			msg = "�亯�ۼ� �Ϸ�.";
			url = "customer_center_qna_view.o?no="+no+"&pages="+pages;
			return SUCCESS;
		}else{
			msg = "�亯�ۼ� ����.";
			return ERROR;
		}
	}
	public String answer_del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		

		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		
		
		int res = 0;
		if(qdb.answerDel_M(no)) res = 1;
		
		
		
		if(res == 1) {
			msg = "�亯���� �Ϸ�";
			url = "customer_center_qna_view.o?pages="+pages+"&no="+no;
			return SUCCESS;
		}else{
			msg = "�亯���� ����";
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
