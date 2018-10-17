package shop;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		
		//�� �Խñ����� Ȯ��
		List_Data_Bean ldata = ldb.getArticle_M(no);
		if(ldata.getSellers() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		//1�̸� ���� 0�̸� ����
		int res = 0;
		if(ldb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "���� ����.";
			url = "mypage_list.o";
					
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
	}

	public void setNo(int no) {
		this.no = no;
	}
	
}
