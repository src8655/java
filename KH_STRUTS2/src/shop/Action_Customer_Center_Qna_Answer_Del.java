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

public class Action_Customer_Center_Qna_Answer_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


}
