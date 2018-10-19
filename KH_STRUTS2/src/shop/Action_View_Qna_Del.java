package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Qna_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int product_no = -1;
	int no = -1;
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
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata = vqdb.getArticle_M(no);
		
		//�� ȸ����ȣ�ϰ� �Խñ��� ȸ����ȣ�ϰ� �ٸ���
		if(vqdata.getGuest_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		
		//����
		
		if(vqdb.delete_M(no)) res = 1;
		
		if(res == 1) {
			msg = "���� ����.";
			url = "view.o?no="+product_no+"&tab=3&pages="+pages;
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
