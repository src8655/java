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

public class Action_Customer_Center_Qna_View extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	Qna_Data_Bean qdata;
	
	@Override
	public String execute() throws Exception {
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
	
	public void setNo(int no) {
		this.no = no;
	}
	public Qna_Data_Bean getQdata() {
		return qdata;
	}


}
