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

public class Action_Customer_Center_Qna_Answer extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	String answer = "";
	
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


}
