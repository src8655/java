package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Qna_Write_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int product_no = -1;
	int sellers_no = -1;
	int category = -1;
	String memo = "";
	int secret = 0;
	int res = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//ȸ������
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(sellers_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		//������ �Է��ߴ���
		if(category == -1) {
			msg = "�з��� ������ �ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "������ �Է��� �ּ���.";
			return ERROR;
		}
		
		
		int guest_no = member_info.getNo();
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		
		//�����͸� ��� ����
		View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
		vqdata.setProduct_no(product_no);
		vqdata.setSellers_no(sellers_no);
		vqdata.setCategory(category);
		vqdata.setMemo(memo);
		vqdata.setSecret(secret);
		vqdata.setGuest_no(guest_no);
		vqdata.setGuest_id(guest_id);
		vqdata.setDates(year+"-"+month+"-"+day);

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		
		
		if(vqdb.insert_M(vqdata)) res = 1;
		
		
		return SUCCESS;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getSellers_no() {
		return sellers_no;
	}

	public void setSellers_no(int sellers_no) {
		this.sellers_no = sellers_no;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
