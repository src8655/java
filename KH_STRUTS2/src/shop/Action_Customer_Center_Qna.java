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

	public Action_Paging getPaging() {
		return paging;
	}
	public List getList() {
		return list;
	}
}
