package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Review_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int product_no = -1;
	int stars = -1;
	String review1 = "";
	String review2 = "";
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
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(stars == -1) {
			msg = "��ǰ�򰡸� �������ּ���";
			return ERROR;
		}
		if(review1.equals("")) {
			msg = "�������򰡸� �Է��� �ּ���.";
			return ERROR;
		}
		if(review2.equals("")) {
			msg = "�������򰡸� �Է��� �ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "������ �Է��� �ּ���.";
			return ERROR;
		}
		
		//���ų����� �����ϴ��� Ȯ��
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		Sell_Data_Bean sdata = sdb.getArticle_M(no);
		
		//�� ���ų����� �ƴϸ�
		if(sdata.getGuest_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//�̹� ���䰡 �����ϸ�
		if(sdata.getHasreview() != 0) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		//�ݼ��� ���̵�
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		View_Review_DB_Bean vrdb = View_Review_DB_Bean.getInstance();
		View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
		vrdata.setDates(year+"-"+month+"-"+day);
		vrdata.setGuest_no(member_info.getNo());
		vrdata.setMemo(memo);
		vrdata.setProduct_no(product_no);
		vrdata.setReview1(review1);
		vrdata.setReview2(review2);
		vrdata.setStars(stars);
		vrdata.setGuest_id(guest_id);
		
		
		
		if(vrdb.insert_M(vrdata)) {
			sdb.updateReview_M(no);	//���ų����� ���䰡 �ۼ��Ǿ��ٴ°��� ����
			res = 1;
		}
		
		return SUCCESS;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getReview1() {
		return review1;
	}

	public void setReview1(String review1) {
		this.review1 = review1;
	}

	public String getReview2() {
		return review2;
	}

	public void setReview2(String review2) {
		this.review2 = review2;
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
