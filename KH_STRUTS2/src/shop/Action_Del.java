package shop;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Del extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		
		//내 게시글인지 확인
		List_Data_Bean ldata = ldb.getArticle_M(no);
		if(ldata.getSellers() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		//1이면 성공 0이면 실패
		int res = 0;
		if(ldb.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "삭제 성공.";
			url = "mypage_list.o";
					
			return SUCCESS;
		}else{
			msg = "삭제 실패.";
			return ERROR;
		}
	}

	public void setNo(int no) {
		this.no = no;
	}
	
}
