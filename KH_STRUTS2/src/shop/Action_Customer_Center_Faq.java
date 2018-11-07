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

public class Action_Customer_Center_Faq extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int category = -1;
	Action_Paging paging;
	List list;
	int board_cnt = 0;
	
	//write_post
	//int category = -1;
	String subject = "";
	String memo = "";
	
	//edit
	int no = -1;
	//int category = -1;
	Faq_Data_Bean fdata;
	
	//edit_post
	//int no = -1;
	int categorys = -1;
	//int category = -1;
	//String subject = "";
	//String memo = "";
	
	//del
	//int no = -1;
	//int category = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		paging = new Action_Paging(fdb.count_M(p_search, p_search_value, category), 10, Integer.parseInt(pages));
		

		list = fdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), p_search, p_search_value, category);
		
		return SUCCESS;
	}
	
	public String write() throws Exception {
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
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
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
		

		if(category == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "������ �Է����ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			return ERROR;
		}
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		fdata.setCategory(category);
		fdata.setSubject(subject);
		fdata.setMemo(memo);
		fdata.setDates(year+"-"+month+"-"+day);
		
		
		int res = 0;
		if(fdb.insert_M(fdata)) res = 1;
		
		
		if(res == 1) {
			msg = "�ۼ� �Ϸ�.";
			url = "customer_center_faq.o";
			return SUCCESS;
		}else{
			msg = "�ۼ� ����.";
			return ERROR;
		}
	}
	public String edit() throws Exception {
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
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		fdata = fdb.getArticle_M(no);

		return SUCCESS;
	}
	public String edit_post() throws Exception {
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
		if(category == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(subject.equals("")) {
			msg = "������ �Է����ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			return ERROR;
		}
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		fdata.setNo(no);
		fdata.setCategory(category);
		fdata.setSubject(subject);
		fdata.setMemo(memo);
		fdata.setDates(year+"-"+month+"-"+day);
		
		
		int res = 0;
		if(fdb.update_M(fdata)) res = 1;
		
		
		if(res == 1) {
			msg = "���� �Ϸ�.";
			url = "customer_center_faq.o?pages="+pages+"&category="+categorys+"&p_search="+p_search+"&p_search_value="+p_search_values;
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
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		
		
		int res = 0;
		if(fdb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "���� �Ϸ�.";
			url = "customer_center_faq.o?pages="+pages+"&category="+category+"&p_search="+p_search+"&p_search_value="+p_search_values;
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "���� ����.";
			return ERROR;
		}
		return null;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public int getBoard_cnt() {
		return board_cnt;
	}

	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
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

	public Faq_Data_Bean getFdata() {
		return fdata;
	}

	public void setFdata(Faq_Data_Bean fdata) {
		this.fdata = fdata;
	}

	public int getCategorys() {
		return categorys;
	}

	public void setCategorys(int categorys) {
		this.categorys = categorys;
	}
	
}
