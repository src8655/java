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

public class Action_Mypage extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	
	//sell
	//�з�(-1 �̸� ��κ���(��ۿϷ�� ����))
	String cate = "-1";
	Action_Paging paging;
	List list;
	
	//sell_post
	int no = -1;
	int status = -1;
	//String cate = "-1";
	String ship_num = "";
	
	//sell_end
	//Action_Paging paging;
	//List list;
	
	//list
	//Action_Paging paging;
	//List list;

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
		
		
		return SUCCESS;
	}
	public String sell() throws Exception {
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

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), Integer.parseInt(cate)), 10, Integer.parseInt(pages));
		
		//����Ʈ ��������
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), Integer.parseInt(cate));

		
		
		return SUCCESS;
	}
	public String sell_post() throws Exception {
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
	public String sell_end() throws Exception {
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
		
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), 5), 10, Integer.parseInt(pages));

		//����Ʈ ��������
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), 5);

		
		
		return SUCCESS;
	}
	public String list() throws Exception {
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
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		paging = new Action_Paging(list_manager.getCount_M(searchs, searchs_value, member_info.getNo(), -1), 20, Integer.parseInt(pages));


		list = list_manager.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, member_info.getNo(), -1);	//����Ʈ�޾ƿ���


		return SUCCESS;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
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
	public String getShip_num() {
		return ship_num;
	}
	public void setShip_num(String ship_num) {
		this.ship_num = ship_num;
	}
	
}
