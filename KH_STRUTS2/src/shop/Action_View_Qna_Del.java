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
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata = vqdb.getArticle_M(no);
		
		//내 회원번호하고 게시글의 회원번호하고 다르면
		if(vqdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		
		//삭제
		
		if(vqdb.delete_M(no)) res = 1;
		
		if(res == 1) {
			msg = "삭제 성공.";
			url = "view.o?no="+product_no+"&tab=3&pages="+pages;
			return SUCCESS;
		}else{
			msg = "삭제 실패.";
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
