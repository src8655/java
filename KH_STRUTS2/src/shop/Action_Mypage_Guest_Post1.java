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

public class Action_Mypage_Guest_Post1 extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
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
		if(sgdb.changeStatus(no, 5)) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


}
