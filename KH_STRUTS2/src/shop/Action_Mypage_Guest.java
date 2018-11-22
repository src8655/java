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

public class Action_Mypage_Guest extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list;

	int process1;
	int process2;
	int process3;
	int process4;
	int process5;
	
	//view
	String times = "";
	Sell_Group_Data_Bean sgdata;
	//List list;
	
	//post2,post1
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
		paging = new Action_Paging(sdb.count_M(member_info.getNo()), 7, Integer.parseInt(pages));
		
		list = sdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count_M2(paging.getBoard_starts(), paging.getBoard_ends(), sdata.getTimes(), sdata.getGuest_no()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		
		//���������ֹ� ����
		process1 = sdb.guest_sell_count_M(member_info.getNo(), 1);
		process2 = sdb.guest_sell_count_M(member_info.getNo(), 2);
		process3 = sdb.guest_sell_count_M(member_info.getNo(), 3);
		process4 = sdb.guest_sell_count_M(member_info.getNo(), 4);
		process5 = sdb.guest_sell_count_M(member_info.getNo(), 5);
		
		return SUCCESS;
	}
	public String view() throws Exception {
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
		
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		sgdata = sgdb.getArticle_M(times);
			

		//�ݾ����·� �ٲٱ�
		sgdata.setMoneys(number_format(sgdata.getMoney()));
		sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
		sgdata.setRmoneys(number_format(sgdata.getRmoney()));
		sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
		sgdata.setPoints(number_format(sgdata.getPoint()));
		
		
		//����κ�
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		list = sdb.getArticles3_M(sgdata.getTimes());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count_M(sdata.getTimes()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		return SUCCESS;
	}
	public String post2() throws Exception {
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
	public String post1() throws Exception {
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
		

		Sell_DB_Bean sgdb = Sell_DB_Bean.getInstance();
		
		//�������� Ȯ��
		Sell_Data_Bean sdata = sgdb.getArticle_M(no);
		
		//�������ƴϸ�
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		//���¸� ��ۿϷ�� ����
		int res = 0;
		if(sgdb.changeStatus_M(no, 5)) {
			res = 1;
			
			//����Ȯ�� �Ϸ� �� ���� �ش� ��ǰ�� ���� ī��Ʈ�� �߰���
			List_DB_Bean ldb = List_DB_Bean.getInstance();
			ldb.addBuy_M(sdata.getProduct_no());
			
			//����Ȯ���� ȸ�� ����Ʈ�� ���űݾ��� 3% ����
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint_M(member_info.getNo(), member_info.getPoint() + (int)(((double)sdata.getRmoney())*(3.0/100.0)));
		}
		
		if(res == 1) {
			msg = "����Ȯ�� ����.";
			url = "mypage_guest.o?pages="+pages;
			return SUCCESS;
		}else{
			msg = "����Ȯ�� ����.";
			return ERROR;
		}
	}
	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
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

	public int getProcess1() {
		return process1;
	}

	public void setProcess1(int process1) {
		this.process1 = process1;
	}

	public int getProcess2() {
		return process2;
	}

	public void setProcess2(int process2) {
		this.process2 = process2;
	}

	public int getProcess3() {
		return process3;
	}

	public void setProcess3(int process3) {
		this.process3 = process3;
	}

	public int getProcess4() {
		return process4;
	}

	public void setProcess4(int process4) {
		this.process4 = process4;
	}

	public int getProcess5() {
		return process5;
	}

	public void setProcess5(int process5) {
		this.process5 = process5;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Sell_Group_Data_Bean getSgdata() {
		return sgdata;
	}
	public void setSgdata(Sell_Group_Data_Bean sgdata) {
		this.sgdata = sgdata;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
