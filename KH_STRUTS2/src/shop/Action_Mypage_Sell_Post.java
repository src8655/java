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

public class Action_Mypage_Sell_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int status = -1;
	String cate = "-1";
	String ship_num = "";
	
	
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
		

		//���º���
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		int res = 0;
		
		//�ԱݿϷ�(2)�����̸�
		if(status == 2) {
			if(sdb.changeStatus_M(no, 3)) res = 1;
		}
		//����غ���(3)�����̸�
		if(status == 3) {
			//������ȣ�� ������ ���
			if(ship_num.equals("")) {
				msg = "������ȣ�� �Է����ּ���.";
				return ERROR;
			}
			if(sdb.changeShipStatus_M(no, ship_num)) res = 1;
		}
		
		if(res == 1) {
			msg = "���� �Ϸ�.";
			url = "mypage_sell.o?pages="+pages+"&cate="+cate;
					
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
		
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getShip_num() {
		return ship_num;
	}
	public void setShip_num(String ship_num) {
		this.ship_num = ship_num;
	}
	

}
