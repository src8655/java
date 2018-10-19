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

public class Action_Customer_Center_Qna_Write_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int category = -1;
	String subject = "";
	String memo = "";
	int res = 0;
	
	@Override
	public String execute() throws Exception {
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


}
