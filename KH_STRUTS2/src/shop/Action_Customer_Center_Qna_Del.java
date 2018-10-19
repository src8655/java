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

public class Action_Customer_Center_Qna_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	@Override
	public String execute() throws Exception {
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}


}
