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

public class Action_Mypage_Admin_Payment_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String times = "";
	int res = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		//���¸� �ԱݿϷ�� ����
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		
		
		if(sgdb.changeStatus_M(times, 2)) res = 1;
		
		if(res == 1) {
			msg = "�Ա�Ȯ�� �Ϸ�.";
			url = "mypage_admin_payment.o";
			return SUCCESS;
		}else{
			msg = "�Ա�Ȯ�� ����.";
			return ERROR;
		}
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}


}
