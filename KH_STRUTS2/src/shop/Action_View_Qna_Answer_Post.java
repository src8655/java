package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Qna_Answer_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int product_no = -1;
	int no = -1;
	String memo = "";
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
		if(member_info.getOrders() != 2) {
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
		View_Qna_Data_Bean vqdata =  vqdb.getArticle_M(no);
		
		//�亯�ڰ� �ƴϸ�
		if(vqdata.getSellers_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		vqdata = new View_Qna_Data_Bean();
		vqdata.setNo(no);
		vqdata.setAnswer(memo);
		vqdata.setIsanswer(1);
		
		
		if(vqdb.answer_M(vqdata)) res = 1;


		
		return SUCCESS;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
