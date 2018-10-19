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

public class Action_Customer_Center_Faq_Write_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int category = -1;
	String subject = "";
	String memo = "";
	
	@Override
	public String execute() throws Exception {
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

	public void setCategory(int category) {
		this.category = category;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


}
