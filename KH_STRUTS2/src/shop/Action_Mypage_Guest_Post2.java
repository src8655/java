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

public class Action_Mypage_Guest_Post2 extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		//�������� Ȯ��
		Sell_Data_Bean sdata = sdb.getArticle_M(no);
		
		//�������ƴϸ�
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//���°� �Աݴ������ �ƴϸ�
		if(sdata.getStatus() != 1) {
			msg = "�Աݴ���� ���¿����� ��Ұ� �����մϴ�.";
			return ERROR;
		}
		
		
		//����Ʈ ����� �׷����� �ƴ��� Ȯ��
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		Sell_Group_Data_Bean sgdata = sgdb.getArticle_M(sdata.getTimes());
		if(sgdata.getPoint() != 0) {
			/*
			response.getWriter().println("<script>");
			response.getWriter().println("alert('����� ����Ʈ�� ��ҵ˴ϴ�.')");
			response.getWriter().println("</script>");
			*/
			//����Ʈ �����ֱ�
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint_M(member_info.getNo(), member_info.getPoint() + sgdata.getPoint());
			sgdb.setPoint_M(sgdata.getNo(), 0);
		}
		
		
		//
		int res = 0;
		if(sdb.delete_M(sdata)) res = 1;
		
		
		if(res == 1) {
			msg = "��� ����.";
			url = "mypage_guest.o?pages="+pages;
			return SUCCESS;
		}else{
			msg = "��� ����.";
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
