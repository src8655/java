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
		
		//회원인지
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		//잘못된 접근 막기
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(stars == -1) {
			msg = "상품평가를 선택해주세요";
			return ERROR;
		}
		if(review1.equals("")) {
			msg = "만족도평가를 입력해 주세요.";
			return ERROR;
		}
		if(review2.equals("")) {
			msg = "만족도평가를 입력해 주세요.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "내용을 입력해 주세요.";
			return ERROR;
		}
		
		//구매내역이 존재하는지 확인
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		Sell_Data_Bean sdata = sdb.getArticle_M(no);
		
		//내 구매내역이 아니면
		if(sdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		//이미 리뷰가 존재하면
		if(sdata.getHasreview() != 0) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		//반숨긴 아이디
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
			sdb.updateReview_M(no);	//구매내역에 리뷰가 작성되었다는것을 적용
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
